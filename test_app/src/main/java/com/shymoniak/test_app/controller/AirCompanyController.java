package com.shymoniak.test_app.controller;

import com.shymoniak.test_app.domain.AirCompanyDTO;
import com.shymoniak.test_app.service.AirCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("airCompany")
public class AirCompanyController {
    @Autowired
    private AirCompanyService airCompanyService;

    @GetMapping({"", "/"})
    ResponseEntity<List<AirCompanyDTO>> showAllAirCompanies() {
        return new ResponseEntity<>(airCompanyService.getAllAirCompanies(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    ResponseEntity<AirCompanyDTO> findAirCompanyById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(airCompanyService.getAirCompanyById(id), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Void> addAirCompany(@RequestBody AirCompanyDTO airCompanyDTO){
        airCompanyService.addAirCompany(airCompanyDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<Void> changeAirCompany(@RequestBody AirCompanyDTO airCompanyDTO){
        airCompanyService.changeAirCompany(airCompanyDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteId/{deleteId}")
    ResponseEntity<Void> deleteAirCompany(@PathVariable("deleteId") Integer id){
        airCompanyService.deleteAirCompany(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
