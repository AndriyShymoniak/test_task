package com.shymoniak.test_app.service.implementations;

import com.shymoniak.test_app.domain.AirplaneDTO;
import com.shymoniak.test_app.entity.Airplane;
import com.shymoniak.test_app.repository.AirplaneRepository;
import com.shymoniak.test_app.service.AirplaneService;
import com.shymoniak.test_app.service.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void moveToAnotherAirCompany(Integer airplaneId, Integer airCompanyId) {
        try {
            Airplane airplane = airplaneRepository.getOne(airplaneId);
            airplane.setAirCompanyId(airCompanyId);
            airplaneRepository.save(airplane);
        } catch (EntityNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addAirplane(AirplaneDTO airplaneDTO) {
        airplaneRepository.save(modelMapper.map(airplaneDTO, Airplane.class));
    }
}
