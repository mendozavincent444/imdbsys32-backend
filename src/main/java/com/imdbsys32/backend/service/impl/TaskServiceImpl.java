package com.imdbsys32.backend.service.impl;

import com.imdbsys32.backend.model.Task;
import com.imdbsys32.backend.repository.TaskRepository;
import com.imdbsys32.backend.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void storeTask(Task task) {
        this.taskRepository.save(task);
    }

    @Override
    public List<Task> getTasks() {
        return this.taskRepository.findAll();
    }

    @Override
    public void acceptTask(String taskId) {
        Task task = this.taskRepository.findById(taskId).get();

        task.setStatus("Active");

        this.taskRepository.save(task);
    }

    @Override
    public void deleteTask(String taskId) {
        this.taskRepository.deleteById(taskId);
    }
}
