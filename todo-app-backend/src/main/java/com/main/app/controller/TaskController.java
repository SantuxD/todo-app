package com.main.app.controller;

import com.main.app.documents.Task;
import com.main.app.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(taskService.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findAll(@PathVariable String id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(taskService.findById(id));

    }

    @GetMapping("/keyword/{keyword}")
    public ResponseEntity<List<Task>> findAllByKeyword(@PathVariable String keyword) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(taskService.findByTitle(keyword));

    }

    @PostMapping
    public ResponseEntity<Task> save(@RequestBody Task task) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(taskService.createTask(task));
    }

    @PutMapping
    public ResponseEntity<Task> update(@RequestBody Task task) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(taskService.updateTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
