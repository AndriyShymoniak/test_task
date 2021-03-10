package com.shymoniak.test_app.controller;

import com.shymoniak.test_app.domain.FlightDTO;
import com.shymoniak.test_app.entity.Flight;
import com.shymoniak.test_app.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @GetMapping("/getActiveAndCreatedDayAgo")
    ResponseEntity<List<FlightDTO>> findAllActiveCreatedDayAgo() {
        return new ResponseEntity<>(
                flightService.findAllActiveAndStartedADayAgo(),
                HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Void> addFlightWithStatusPending(@RequestBody FlightDTO dto) {
        flightService.addFlightWithStatusPending(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping("/changeFlightAccordingToStatus/{id}/{date}")
    ResponseEntity<Void> changeFlightDueToStatus(
            @PathVariable("id") Integer id,
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,
                    pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
        System.out.println(date);
        flightService.changeFlightDueToStatusConditions(id, date);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findAllCompletedWithLongerFlightTime/{date}")
    ResponseEntity<List<FlightDTO>> findAllCompletedWithLongerFlightTime(
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,
                    pattern = "HH:mm:ss")Date date){
        return new ResponseEntity<>(flightService.findAllCompletedWithLongerFlightTime(date), HttpStatus.OK);
    }
}
