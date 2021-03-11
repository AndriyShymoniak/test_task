package com.shymoniak.testapp.service.implementations;

import com.shymoniak.testapp.domain.FlightDTO;
import com.shymoniak.testapp.entity.Flight;
import com.shymoniak.testapp.entity.enums.FlightStatus;
import com.shymoniak.testapp.repository.FlightRepository;
import com.shymoniak.testapp.service.FlightService;
import com.shymoniak.testapp.service.utils.ObjectMapperUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public List<FlightDTO> findAllByAirCompanyNameAndStatus(String airCompanyCame,
                                                            String status) {
        return modelMapper.mapAll(
                flightRepository.findAllByNameAndStatus(airCompanyCame, status),
                FlightDTO.class);
    }

    @Override
    public List<FlightDTO> findAllActiveAndStartedADayAgo() {
        DateTime dateTime = new DateTime().minusHours(24);
        return modelMapper.mapAll(
                flightRepository.findAllByFlightStatusAndStartedAtBefore(
                        FlightStatus.ACTIVE, dateTime.toDate()),
                FlightDTO.class
        );
    }

    @Override
    public void addFlightWithStatusPending(FlightDTO flightDTO) {
        Flight flight = modelMapper.map(flightDTO, Flight.class);
        flight.setFlightStatus(FlightStatus.PENDING);
        flightRepository.save(flight);
    }

    @Override
    public void changeFlightDueToStatusConditions(Integer id, Date date) {
        Flight flight = flightRepository.getOne(id);
        if (flight.getFlightStatus() == FlightStatus.ACTIVE) {
            flight.setStartedAt(date);
        } else if (flight.getFlightStatus() == FlightStatus.COMPLETED) {
            flight.setEndedAt(date);
        } else if (flight.getFlightStatus() == FlightStatus.DELAYED) {
            flight.setDelayStartedAt(date);
        }
        flightRepository.save(flight);
    }

    @Override
    public List<FlightDTO> findAllCompletedWithLongerFlightTime(Date estimated) {
        return modelMapper.mapAll(
                flightRepository.findAllCompletedWithLongerFlightTime(estimated),
                FlightDTO.class);
    }
}