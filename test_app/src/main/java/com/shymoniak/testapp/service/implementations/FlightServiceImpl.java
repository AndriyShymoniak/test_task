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

import javax.persistence.EntityNotFoundException;
import java.io.InvalidObjectException;
import java.lang.reflect.Field;
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
        if (isValid(flightDTO)) {
            Flight flight = modelMapper.map(flightDTO, Flight.class);
            flight.setFlightStatus(FlightStatus.PENDING);
            flightRepository.save(flight);
        } else {
            throw new InvalidObjectException("Fields must not be null.");
        }
    }

    @Override
    public void changeFlightDueToStatusConditions(Integer id, Date date) throws EntityNotFoundException {
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

    private boolean isValid(FlightDTO obj) {
        try {
            Class<?> objClass = obj.getClass();
            Field[] fields = objClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(obj).equals(null) || field.get(obj).equals(0)
                        && !field.getName().equals("id")
                        && !field.getName().equals("endedAt")
                        && !field.getName().equals("delayStartedAt")
                        && !field.getName().equals("startedAt")
                        && !field.getName().equals("flightStatus")) {
                    return false;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
