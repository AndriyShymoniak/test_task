package com.shymoniak.test_app.service.implementations;

import com.shymoniak.test_app.domain.FlightDTO;
import com.shymoniak.test_app.entity.enums.FlightStatus;
import com.shymoniak.test_app.repository.FlightRepository;
import com.shymoniak.test_app.service.FlightService;
import com.shymoniak.test_app.service.utils.ObjectMapperUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public List<FlightDTO> findAllByAirCompanyNameAndStatus(String airCompanyCame, String status) {
        return modelMapper.mapAll(
                flightRepository.findAllByNameAndStatus(airCompanyCame, status),
                FlightDTO.class);
    }

    @Override
    public List<FlightDTO> findAllActiveAndCreatedADayAgo() {
        DateTime dateTime = new DateTime().minusHours(24);
        return modelMapper.mapAll(
                flightRepository.findAllByFlightStatusAndCreatedAtBefore(FlightStatus.ACTIVE, dateTime.toDate())
                , FlightDTO.class
        );
    }
}
