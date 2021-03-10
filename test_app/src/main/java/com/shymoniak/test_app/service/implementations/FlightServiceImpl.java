package com.shymoniak.test_app.service.implementations;

import com.shymoniak.test_app.domain.FlightDTO;
import com.shymoniak.test_app.repository.FlightRepository;
import com.shymoniak.test_app.service.FlightService;
import com.shymoniak.test_app.service.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
