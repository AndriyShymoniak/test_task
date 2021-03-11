package com.shymoniak.testapp.controller;

import com.shymoniak.testapp.domain.AirCompanyDTO;
import com.shymoniak.testapp.service.AirCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InvalidObjectException;
import java.util.List;

@RestController
@RequestMapping("airCompany")
public class AirCompanyController {
    @Autowired
    private AirCompanyService airCompanyService;

    @GetMapping({"", "/"})
    ResponseEntity<List<AirCompanyDTO>> showAllAirCompanies() {
        return new ResponseEntity<>(airCompanyService.getAllAirCompanies(),
                HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    ResponseEntity<AirCompanyDTO> findAirCompanyById(@PathVariable("id")
                                                             Integer id) {
        try {
            AirCompanyDTO airCompanyDTO = airCompanyService.getAirCompanyById(id);
            return new ResponseEntity<>(airCompanyDTO, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @PostMapping
    ResponseEntity<Void> addAirCompany(@RequestBody AirCompanyDTO airCompany) {
        try {
            airCompanyService.addAirCompany(airCompany);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (InvalidObjectException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping
    ResponseEntity<Void> changeAirCompany(@RequestBody AirCompanyDTO airCompany) {
        try {
            airCompanyService.changeAirCompany(airCompany);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (InvalidObjectException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/deleteId/{deleteId}")
    ResponseEntity<Void> deleteAirCompany(@PathVariable("deleteId") Integer id) {
        try {
            airCompanyService.deleteAirCompany(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
