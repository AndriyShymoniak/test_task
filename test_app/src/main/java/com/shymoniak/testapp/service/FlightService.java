package com.shymoniak.testapp.service;

import com.shymoniak.testapp.domain.FlightDTO;

import java.util.Date;
import java.util.List;

public interface FlightService {
    void addFlightWithStatusPending(FlightDTO flightDTO);

    void changeFlightDueToStatusConditions(Integer id, Date date);

    List<FlightDTO> findAllByAirCompanyNameAndStatus(String airCompanyName,
                                                     String status);

    List<FlightDTO> findAllActiveAndStartedADayAgo();

    List<FlightDTO> findAllCompletedWithLongerFlightTime(Date estimated);
}
