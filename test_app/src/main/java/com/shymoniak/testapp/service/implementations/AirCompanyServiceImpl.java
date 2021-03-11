package com.shymoniak.testapp.service.implementations;

import com.shymoniak.testapp.domain.AirCompanyDTO;
import com.shymoniak.testapp.entity.AirCompany;
import com.shymoniak.testapp.repository.AirCompanyRepository;
import com.shymoniak.testapp.service.AirCompanyService;
import com.shymoniak.testapp.service.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public AirCompanyDTO getAirCompanyById(int id) {
        return modelMapper.map(airCompanyRepository.getOne(id),
                AirCompanyDTO.class);
    }

    @Override
    public void addAirCompany(AirCompanyDTO airCompany) {
        airCompanyRepository.save(modelMapper.map(airCompany,
                AirCompany.class));
    }

    @Override
    public void changeAirCompany(AirCompanyDTO airCompany) {
        airCompanyRepository.save(modelMapper.map(airCompany,
                AirCompany.class));
    }

    @Override
    public void deleteAirCompany(Integer id) {
        airCompanyRepository.deleteById(id);
    }
}
