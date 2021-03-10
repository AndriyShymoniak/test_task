package com.shymoniak.test_app.controller;

import com.shymoniak.test_app.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("airplane")
public class AirplaneController {
    @Autowired
    private AirplaneService airplaneService;

    @RequestMapping("/changeAirCompany/{id}/{airCompanyId}")
    ResponseEntity<Void> moveToAnotherAirCompany(@PathVariable("id") Integer id,
                                                 @PathVariable("airCompanyId") Integer airCompanyId) {
        airplaneService.moveToAnotherAirCompany(id, airCompanyId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
