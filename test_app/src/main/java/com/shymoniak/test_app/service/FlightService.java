package com.shymoniak.test_app.service;

import com.shymoniak.test_app.domain.FlightDTO;

import java.util.Date;
import java.util.List;

public interface FlightService {
    List<FlightDTO> findAllByAirCompanyNameAndStatus(String airCompanyName, String status);
    List<FlightDTO> findAllActiveAndStartedADayAgo();
    void addFlightWithStatusPending(FlightDTO flightDTO);
    void changeFlightDueToStatusConditions(Integer id, Date date);
}
