package com.main.app.repository;

import com.main.app.documents.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskRepository extends MongoRepository<Task,String> {
    List<Task> findByTitleContainingIgnoreCase(String title);
}
