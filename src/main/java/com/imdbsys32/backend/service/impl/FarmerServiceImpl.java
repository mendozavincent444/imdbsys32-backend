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
        // db.inventory.insertOne( {
        // firstName: farmer.getFirstName() ,
        // lastName: farmer.getLastName() ,
        // email: farmer.getEmail() ,
        // address: farmer.getAddress() ,
        // contactNumber: farmer.getContactNumber() } )
        return this.farmerRepository.save(farmer).getId();
    }

    @Override
    public List<Farmer> getFarmers() {
        //db.farmers.find( {} )
        return this.farmerRepository.findAll();
    }

    @Override
    public void deleteFarmer(String farmerId) {
        //db.farmers.deleteOne( { id: farmerId } )
        this.farmerRepository.deleteById(farmerId);
    }

    @Override
    public void updateFarmer(Farmer farmer, String farmerId) {
        Farmer farmerToUpdate = this.farmerRepository.findById(farmerId).get();

        farmerToUpdate.setFirstName(farmer.getFirstName());
        farmerToUpdate.setLastName(farmer.getLastName());
        farmerToUpdate.setEmail(farmer.getEmail());
        farmerToUpdate.setAddress(farmer.getAddress());
        farmerToUpdate.setContactNumber(farmer.getContactNumber());

        this.farmerRepository.save(farmerToUpdate);
    }

    @Override
    public List<Farmer> searchFarmers(String searchValue) {
        // db.farmers.find({
        //  $or: [
        //    { firstName: { $regex: /searchValue/i } },
        //    { lastName: { $regex: /searchValue/i } }
        //  ]
        //})
        return this.farmerRepository.findByFirstNameContainingOrLastNameContainingAllIgnoreCase(searchValue, searchValue);
    }
}
