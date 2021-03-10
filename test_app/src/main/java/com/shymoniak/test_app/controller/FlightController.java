package com.shymoniak.test_app.controller;

import com.shymoniak.test_app.domain.AirCompanyDTO;
import com.shymoniak.test_app.domain.FlightDTO;
import com.shymoniak.test_app.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/getByAirCompanyAndStatus/{name}/{status}")
    ResponseEntity<List<FlightDTO>> moveToAnotherAirCompany(
            @PathVariable("name") String name,
            @PathVariable("status") String status) {
        return new ResponseEntity<>(
                flightService.findAllByAirCompanyNameAndStatus(name, status),
                HttpStatus.OK);
    }
}
