package com.shymoniak.testapp.service.implementations;

import com.shymoniak.testapp.domain.AirCompanyDTO;
import com.shymoniak.testapp.entity.AirCompany;
import com.shymoniak.testapp.repository.AirCompanyRepository;
import com.shymoniak.testapp.service.AirCompanyService;
import com.shymoniak.testapp.service.utils.ObjectMapperUtils;
import com.shymoniak.testapp.service.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InvalidObjectException;
import java.util.List;
import java.util.Optional;

@Service
public class AirCompanyServiceImpl implements AirCompanyService {

    @Autowired
    private AirCompanyRepository airCompanyRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Autowired
    Validator validator;

    @Override
    public List<AirCompanyDTO> getAllAirCompanies() {
        return modelMapper.mapAll(airCompanyRepository.findAll(),
                AirCompanyDTO.class);
    }

    @Override
    public AirCompanyDTO getAirCompanyById(int id) throws IllegalArgumentException{
        Optional<AirCompany> airCompany = airCompanyRepository.findById(id);
        if (airCompany.isPresent()){
            return modelMapper.map(airCompanyRepository.getOne(id),
                    AirCompanyDTO.class);
        } else {
            throw new IllegalArgumentException("There is no such record in Database");
        }
    }

    @Override
    public void addAirCompany(AirCompanyDTO airCompany) throws InvalidObjectException {
        if (validator.isValid(airCompany)) {
            airCompanyRepository.save(modelMapper.map(airCompany,
                    AirCompany.class));
        } else {
            throw new InvalidObjectException("Fields must not be null.");
        }
    }

    @Override
    public void changeAirCompany(AirCompanyDTO airCompany) throws InvalidObjectException {
        if (validator.isValid(airCompany)) {
            airCompanyRepository.save(modelMapper.map(airCompany,
                    AirCompany.class));
        } else {
            throw new InvalidObjectException("Fields must not be null.");
        }
    }

    @Override
    public void deleteAirCompany(Integer id) throws IllegalArgumentException {
        Optional<AirCompany> airCompany = airCompanyRepository.findById(id);
        if (airCompany.isPresent()){
            airCompanyRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("There is no such record in Database");
        }
    }
}
