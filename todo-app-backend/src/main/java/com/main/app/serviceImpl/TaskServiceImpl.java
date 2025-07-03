package com.main.app.serviceImpl;

import com.main.app.documents.Task;
import com.main.app.exceptions.APIException;
import com.main.app.repository.TaskRepository;
import com.main.app.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        task.setDone(false);
        return taskRepository.save(task);
    }

    @Override
    public Task findById(String id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new APIException("Task not found"));
    }

    @Override
    public List<Task> findByTitle(String title) {
        return taskRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Task task) {
        Task oldTask = findById(task.getId());
        oldTask.setTitle(task.getTitle() != null && !task.getTitle().isEmpty()
                ? task.getTitle() : oldTask.getTitle());
        oldTask.setDescription(task.getDescription() != null &&  !task.getDescription().isEmpty()
                ? task.getDescription() : oldTask.getDescription());
        return taskRepository.save(oldTask);
    }

    @Override
    public void deleteById(String id) {
        Task task = findById(id);
        taskRepository.delete(task);
    }

    @Override
    public Task markAsDone(String id, Boolean isDone) {
        Task task = findById(id);
        task.setDone(isDone);
        return taskRepository.save(task);
    }
}
