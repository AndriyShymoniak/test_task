package com.shymoniak.testapp.service.implementations;

import com.shymoniak.testapp.domain.FlightDTO;
import com.shymoniak.testapp.entity.Flight;
import com.shymoniak.testapp.entity.enums.FlightStatus;
import com.shymoniak.testapp.repository.FlightRepository;
import com.shymoniak.testapp.service.FlightService;
import com.shymoniak.testapp.service.utils.ObjectMapperUtils;
import com.shymoniak.testapp.service.utils.Validator;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InvalidObjectException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Autowired
    private Validator validator;

    @Override
    public List<FlightDTO> findAllByAirCompanyNameAndStatus(String airCompanyCame,
                                                            String status) {
        return modelMapper.mapAll(
                flightRepository.findAllByNameAndStatus(airCompanyCame, status),
                FlightDTO.class);
    }

    @Override
    public List<FlightDTO> findAllActiveAndStartedMoreThenDayAgo() {
        DateTime dateTime = new DateTime().minusHours(24);
        return modelMapper.mapAll(
                flightRepository.findAllByFlightStatusAndStartedAtBefore(
                        FlightStatus.ACTIVE, dateTime.toDate()),
                FlightDTO.class
        );
    }

    @Override
    public void addFlightWithStatusPending(FlightDTO flightDTO) throws InvalidObjectException {
        if (validator.isValid(flightDTO)) {
            Flight flight = modelMapper.map(flightDTO, Flight.class);
            flight.setFlightStatus(FlightStatus.PENDING);
            flightRepository.save(flight);
        } else {
            throw new InvalidObjectException("Fields must not be null.");
        }
    }

    @Override
    public void changeFlightDueToStatusConditions(Integer id, Date date) throws IllegalArgumentException {
        Optional<Flight> optFlight = flightRepository.findById(id);
        if (optFlight.isPresent()) {
            Flight flight = flightRepository.getOne(id);
            if (flight.getFlightStatus() == FlightStatus.ACTIVE) {
                flight.setStartedAt(date);
            } else if (flight.getFlightStatus() == FlightStatus.COMPLETED) {
                flight.setEndedAt(date);
            } else if (flight.getFlightStatus() == FlightStatus.DELAYED) {
                flight.setDelayStartedAt(date);
            }
            flightRepository.save(flight);
        } else {
            throw new IllegalArgumentException("There is no such record in " +
                    "Database");
        }
    }

    @Override
    public List<FlightDTO> findAllCompletedWithLongerFlightTime(Date estimated) {
        return modelMapper.mapAll(
                flightRepository.findAllCompletedWithLongerFlightTime(estimated),
                FlightDTO.class);
    }
}
