package com.shymoniak.testapp.controller;

import com.shymoniak.testapp.domain.AirplaneDTO;
import com.shymoniak.testapp.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("airplane")
public class AirplaneController {
    @Autowired
    private AirplaneService airplaneService;

    @PostMapping
    ResponseEntity<Void> addAirplane(@RequestBody AirplaneDTO airplane) {
        airplaneService.addAirplane(airplane);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping("/changeAirCompany/{id}/{airCompanyId}")
    ResponseEntity<Void> changeAirCompany(@PathVariable("id") Integer id,
                                          @PathVariable("airCompanyId")
                                                  Integer airCompanyId) {
        airplaneService.moveToAnotherAirCompany(id, airCompanyId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
