package com.shymoniak.test_app.service.implementations;

import com.shymoniak.test_app.domain.AirCompanyDTO;
import com.shymoniak.test_app.entity.AirCompany;
import com.shymoniak.test_app.repository.AirCompanyRepository;
import com.shymoniak.test_app.service.AirCompanyService;
import com.shymoniak.test_app.service.utils.ObjectMapperUtils;
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
        return modelMapper.mapAll(airCompanyRepository.findAll(), AirCompanyDTO.class);
    }

    @Override
    public AirCompanyDTO getAirCompanyById(int id) {
        return modelMapper.map(airCompanyRepository.getOne(id), AirCompanyDTO.class);
    }

    @Override
    public void addAirCompany(AirCompanyDTO airCompanyDTO) {
        airCompanyRepository.save(modelMapper.map(airCompanyDTO, AirCompany.class));
    }

    @Override
    public void changeAirCompany(AirCompanyDTO airCompanyDTO) {
        airCompanyRepository.save(modelMapper.map(airCompanyDTO, AirCompany.class));
    }

    @Override
    public void deleteAirCompany(Integer id) {
        airCompanyRepository.deleteById(id);
    }
}
