package com.imdbsys32.backend.service.impl;

import com.imdbsys32.backend.model.Farmer;
import com.imdbsys32.backend.repository.FarmerRepository;
import com.imdbsys32.backend.service.FarmerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerServiceImpl implements FarmerService {

    private final FarmerRepository farmerRepository;

    public FarmerServiceImpl(FarmerRepository studentRepository) {
        this.farmerRepository = studentRepository;
    }

    @Override
    public String saveFarmer(Farmer farmer) {
        return this.farmerRepository.save(farmer).getId();
    }

    @Override
    public List<Farmer> getFarmers() {
        return this.farmerRepository.findAll();
    }

    @Override
    public void deleteFarmer(String studentId) {
        this.farmerRepository.deleteById(studentId);
    }

    @Override
    public void updateFarmer(Farmer student, String studentId) {
        Farmer farmerToUpdate = this.farmerRepository.findById(studentId).get();

        farmerToUpdate.setFirstName(student.getFirstName());
        farmerToUpdate.setLastName(student.getLastName());
        farmerToUpdate.setEmail(student.getEmail());
        farmerToUpdate.setAddress(student.getAddress());
        farmerToUpdate.setContactNumber(student.getContactNumber());

        this.farmerRepository.save(farmerToUpdate);
    }

    @Override
    public List<Farmer> searchFarmers(String searchValue) {
        return this.farmerRepository.findByFirstNameContainingOrLastNameContainingAllIgnoreCase(searchValue, searchValue);
    }
}
