package com.imdbsys32.backend.controller;

import com.imdbsys32.backend.model.Task;
import com.imdbsys32.backend.service.TaskService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/tasks")
@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Void> storeTask(@RequestBody Task task) {
        this.taskService.storeTask(task);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        List<Task> allTasks = this.taskService.getTasks();

        return new ResponseEntity<>(allTasks, HttpStatus.OK);
    }
    @PatchMapping
    public ResponseEntity<String> acceptTask(@RequestBody String taskId) {

        this.taskService.acceptTask(taskId);

        return new ResponseEntity<>("Task is now active.", HttpStatus.OK);
    }

    @DeleteMapping("/{task-id}")
    public ResponseEntity<String> deleteTask(@PathVariable(name = "task-id") String taskId) {
        this.taskService.deleteTask(taskId);

        return new ResponseEntity<>("Task deleted successfully.", HttpStatus.OK);
    }
}
