package com.shymoniak.test_app.service;

import com.shymoniak.test_app.domain.AirCompanyDTO;

import java.util.List;

public interface AirCompanyService {
    List<AirCompanyDTO> getAllAirCompanies();
    AirCompanyDTO getAirCompanyById(int id);
    void addAirCompany(AirCompanyDTO airCompanyDTO);
    void changeAirCompany(AirCompanyDTO airCompanyDTO);
    void deleteAirCompany(Integer id);
}
