package com.imdbsys32.backend.controller;

import com.imdbsys32.backend.model.Farmer;
import com.imdbsys32.backend.service.FarmerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/farmers")
@RestController
public class FarmerController {

    private final FarmerService farmerService;

    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @PostMapping
    public ResponseEntity<String> addFarmer(@RequestBody Farmer farmer) {
        this.farmerService.saveFarmer(farmer);

        return new ResponseEntity<>("Farmer added successfully.", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Farmer>> fetchFarmers() {

        List<Farmer> allFarmers = this.farmerService.getFarmers();

        return new ResponseEntity<>(allFarmers, HttpStatus.OK);
    }

    @DeleteMapping("/{farmerId}")
    public ResponseEntity<String> deleteFarmer(@PathVariable String farmerId) {

        this.farmerService.deleteFarmer(farmerId);

        return new ResponseEntity<>("Farmer deleted successfully.", HttpStatus.OK);
    }


    @PutMapping("/{farmerId}")
    public ResponseEntity<String> updateFarmer(@RequestBody Farmer farmer, @PathVariable String farmerId) {

        this.farmerService.updateFarmer(farmer, farmerId);

        return new ResponseEntity<>("Farmer updated successfully.", HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Farmer>> searchFarmers(@RequestParam(value = "searchValue") String searchValue){
        List<Farmer> students = this.farmerService.searchFarmers(searchValue);

        return new ResponseEntity<>(students, HttpStatus.OK);

    }

}
