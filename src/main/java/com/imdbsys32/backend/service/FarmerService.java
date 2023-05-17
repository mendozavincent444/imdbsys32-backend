package com.imdbsys32.backend.service;

import com.imdbsys32.backend.model.Farmer;

import java.util.List;

public interface FarmerService {
    public String saveFarmer(Farmer student);

    public List<Farmer> getFarmers();

    public void deleteFarmer(String studentId);

    public void updateFarmer(Farmer student, String studentId);

    public List<Farmer> searchFarmers(String searchValue);
}
