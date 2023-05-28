package com.imdbsys32.backend.service;

import com.imdbsys32.backend.model.Farmer;

import java.util.List;

public interface FarmerService {
    public void saveFarmer(Farmer farmer);

    public List<Farmer> getFarmers();

    public void deleteFarmer(String farmerId);

    public void updateFarmer(Farmer farmer, String farmerId);

    public List<Farmer> searchFarmers(String searchValue);
}
