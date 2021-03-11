package com.shymoniak.testapp.controller;

import com.shymoniak.testapp.domain.FlightDTO;
import com.shymoniak.testapp.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.io.InvalidObjectException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/findAllByAirCompanyAndStatus/{name}/{status}")
    ResponseEntity<List<FlightDTO>> findAllByAirCompanyAndStatus(
            @PathVariable("name") String name,
            @PathVariable("status") String status) {
        return new ResponseEntity<>(
                flightService.findAllByAirCompanyNameAndStatus(name, status),
                HttpStatus.OK);
    }

    @GetMapping("/findAllActiveStartedDayAgo")
    ResponseEntity<List<FlightDTO>> findAllActiveStartedMoreThenDayAgo() {
        return new ResponseEntity<>(
                flightService.findAllActiveAndStartedMoreThenDayAgo(),
                HttpStatus.OK);
    }

    @GetMapping("/findAllCompletedWithLongerFlightTime/{date}")
    ResponseEntity<List<FlightDTO>> findAllCompletedWithLongerFlightTime(
            @PathVariable("date") @DateTimeFormat(iso =
                    DateTimeFormat.ISO.DATE, pattern = "HH:mm:ss") Date date) {
        return new ResponseEntity<>(
                flightService.findAllCompletedWithLongerFlightTime(date),
                HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Void> addFlightWithStatusPending(@RequestBody FlightDTO flight) {
        try {
            flightService.addFlightWithStatusPending(flight);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (InvalidObjectException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping("/changeFlightAccordingToStatus/{id}/{date}")
    ResponseEntity<Void> changeFlightDueToStatus(
            @PathVariable("id") Integer id,
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,
                    pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
        try {
            flightService.changeFlightDueToStatusConditions(id, date);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
