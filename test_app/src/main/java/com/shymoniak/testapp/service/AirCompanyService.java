package com.shymoniak.testapp.service;

import com.shymoniak.testapp.domain.AirCompanyDTO;

import java.util.List;

public interface AirCompanyService {
    void addAirCompany(AirCompanyDTO airCompanyDTO);

    void changeAirCompany(AirCompanyDTO airCompanyDTO);

    void deleteAirCompany(Integer id);

    AirCompanyDTO getAirCompanyById(int id);

    List<AirCompanyDTO> getAllAirCompanies();
}
