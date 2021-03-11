package com.shymoniak.testapp.service.implementations;

import com.shymoniak.testapp.domain.AirCompanyDTO;
import com.shymoniak.testapp.entity.AirCompany;
import com.shymoniak.testapp.repository.AirCompanyRepository;
import com.shymoniak.testapp.service.AirCompanyService;
import com.shymoniak.testapp.service.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.InvalidObjectException;
import java.lang.reflect.Field;
import java.util.List;

@Service
public class AirCompanyServiceImpl implements AirCompanyService {

    @Autowired
    private AirCompanyRepository airCompanyRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public List<AirCompanyDTO> getAllAirCompanies() {
        return modelMapper.mapAll(airCompanyRepository.findAll(),
                AirCompanyDTO.class);
    }

    @Override
    public AirCompanyDTO getAirCompanyById(int id) throws EntityNotFoundException {
        return modelMapper.map(airCompanyRepository.getOne(id),
                AirCompanyDTO.class);
    }

    @Override
    public void addAirCompany(AirCompanyDTO airCompany) throws InvalidObjectException {
        if (isValid(airCompany)) {
            airCompanyRepository.save(modelMapper.map(airCompany,
                    AirCompany.class));
        } else {
            throw new InvalidObjectException("Fields must not be null.");
        }
    }

    @Override
    public void changeAirCompany(AirCompanyDTO airCompany) throws InvalidObjectException {
        if (isValid(airCompany)) {
            airCompanyRepository.save(modelMapper.map(airCompany,
                    AirCompany.class));
        } else {
            throw new InvalidObjectException("Fields must not be null.");
        }
    }

    @Override
    public void deleteAirCompany(Integer id) throws EntityNotFoundException {
        airCompanyRepository.getOne(id);
        airCompanyRepository.deleteById(id);
    }

    private boolean isValid(AirCompanyDTO obj) {
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(obj).equals(null) || field.get(obj).equals(0)
                        && !field.getName().equals("id")) {
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
