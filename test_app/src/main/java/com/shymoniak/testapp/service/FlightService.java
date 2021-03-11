package com.shymoniak.testapp.service;

import com.shymoniak.testapp.domain.FlightDTO;

import java.io.InvalidObjectException;
import java.util.Date;
import java.util.List;

public interface FlightService {
    void addFlightWithStatusPending(FlightDTO flightDTO) throws InvalidObjectException;

    void changeFlightDueToStatusConditions(Integer id, Date date);

    List<FlightDTO> findAllByAirCompanyNameAndStatus(String airCompanyName,
                                                     String status);

    List<FlightDTO> findAllActiveAndStartedMoreThenDayAgo();

    List<FlightDTO> findAllCompletedWithLongerFlightTime(Date estimated);
}
