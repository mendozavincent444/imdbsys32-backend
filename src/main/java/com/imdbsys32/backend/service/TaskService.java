package com.imdbsys32.backend.service;

import com.imdbsys32.backend.model.Task;

import java.util.List;

public interface TaskService {
    public void storeTask(Task task);

    public List<Task> getTasks();

    public void acceptTask(String taskId);

    public void deleteTask(String taskId);
}
