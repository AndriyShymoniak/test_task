package com.shymoniak.testapp.service.implementations;

import com.shymoniak.testapp.domain.AirplaneDTO;
import com.shymoniak.testapp.entity.Airplane;
import com.shymoniak.testapp.repository.AirplaneRepository;
import com.shymoniak.testapp.service.AirplaneService;
import com.shymoniak.testapp.service.utils.ObjectMapperUtils;
import com.shymoniak.testapp.service.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InvalidObjectException;
import java.util.Optional;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Autowired
    private Validator validator;

    @Override
    public void moveToAnotherAirCompany(
            Integer airplaneId, Integer airCompanyId) throws IllegalArgumentException {
        Optional<Airplane> optAirplane = airplaneRepository.findById(airplaneId);
        if (optAirplane.isPresent()){
            Airplane airplane = airplaneRepository.getOne(airplaneId);
            airplane.setAirCompanyId(airCompanyId);
            airplaneRepository.save(airplane);
        } else {
            throw new IllegalArgumentException("There is no such record in Database");
        }
    }

    @Override
    public void addAirplane(AirplaneDTO airplane) throws InvalidObjectException {
        if (validator.isValid(airplane)) {
            airplaneRepository.save(modelMapper.map(airplane, Airplane.class));
        } else {
            throw new InvalidObjectException("Fields must not be null.");
        }
    }
}
