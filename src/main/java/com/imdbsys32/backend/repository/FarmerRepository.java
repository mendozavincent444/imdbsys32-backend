package com.imdbsys32.backend.repository;

import com.imdbsys32.backend.model.Farmer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface FarmerRepository extends MongoRepository<Farmer, String> {

    public List<Farmer> findByFirstNameContainingOrLastNameContainingAllIgnoreCase(String firstName, String lastName);
}
