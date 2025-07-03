package com.main.app.service;

import com.main.app.documents.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    Task findById(String id);
    List<Task> findByTitle(String title);
    List<Task> findAll();
    Task updateTask(Task task);
    void deleteById(String id);
    Task markAsDone(String id, Boolean isDone);
}
