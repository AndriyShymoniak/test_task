package com.shymoniak.testapp.service.implementations;

import com.shymoniak.testapp.domain.AirplaneDTO;
import com.shymoniak.testapp.entity.Airplane;
import com.shymoniak.testapp.repository.AirplaneRepository;
import com.shymoniak.testapp.service.AirplaneService;
import com.shymoniak.testapp.service.utils.ObjectMapperUtils;
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
    public void moveToAnotherAirCompany(Integer airplaneId,
                                        Integer airCompanyId) {
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
