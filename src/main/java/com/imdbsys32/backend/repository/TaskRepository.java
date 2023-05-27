package com.imdbsys32.backend.repository;

import com.imdbsys32.backend.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
