package com.imdbsys32.backend.controller;

import com.imdbsys32.backend.model.Farmer;
import com.imdbsys32.backend.service.FarmerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/farmers")
@RestController
public class FarmerController {

    private final FarmerService studentService;


    public FarmerController(FarmerService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Farmer farmer) {
        String createdFarmerId = this.studentService.saveFarmer(farmer);

        return new ResponseEntity<>(createdFarmerId, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Farmer>> fetchStudents() {

        List<Farmer> allStudents = this.studentService.getFarmers();

        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @DeleteMapping("/{farmerId}")
    public ResponseEntity<String> deleteStudent(@PathVariable String farmerId) {

        this.studentService.deleteFarmer(farmerId);

        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }


    @PutMapping("/{farmerId}")
    public ResponseEntity<String> updateStudent(@RequestBody Farmer farmer, @PathVariable String farmerId) {

        this.studentService.updateFarmer(farmer, farmerId);

        return new ResponseEntity<>("Updated successfully", HttpStatus.OK);




    }

    @GetMapping("/search")
    public ResponseEntity<List<Farmer>> searchStudents (@RequestParam(value = "searchValue") String searchValue){
        List<Farmer> students = this.studentService.searchFarmers(searchValue);

        return new ResponseEntity<>(students, HttpStatus.OK);

    }

}
