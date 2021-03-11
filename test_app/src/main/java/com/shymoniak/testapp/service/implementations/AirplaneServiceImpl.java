package com.shymoniak.testapp.service.implementations;

import com.shymoniak.testapp.domain.AirplaneDTO;
import com.shymoniak.testapp.entity.Airplane;
import com.shymoniak.testapp.repository.AirplaneRepository;
import com.shymoniak.testapp.service.AirplaneService;
import com.shymoniak.testapp.service.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.InvalidObjectException;
import java.lang.reflect.Field;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void moveToAnotherAirCompany(
            Integer airplaneId, Integer airCompanyId) throws EntityNotFoundException {
        Airplane airplane = airplaneRepository.getOne(airplaneId);
        airplane.setAirCompanyId(airCompanyId);
        airplaneRepository.save(airplane);
    }

    @Override
    public void addAirplane(AirplaneDTO airplane) throws InvalidObjectException {
        if (isValid(airplane)) {
            airplaneRepository.save(modelMapper.map(airplane, Airplane.class));
        } else {
            throw new InvalidObjectException("Fields must not be null.");
        }
    }

    private boolean isValid(AirplaneDTO obj) {
        try {
            Class<?> objClass = obj.getClass();
            Field[] fields = objClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(obj).equals(null) || field.get(obj).equals(0)
                        && !field.getName().equals("id")
                        && !field.getName().equals("airCompanyId")
                        && !field.getName().equals("numberOfFlights")) {
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
