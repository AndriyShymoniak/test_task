package com.shymoniak.testapp.service;

import com.shymoniak.testapp.domain.AirCompanyDTO;

import java.io.InvalidObjectException;
import java.util.List;

public interface AirCompanyService {
    void addAirCompany(AirCompanyDTO airCompanyDTO) throws InvalidObjectException;

    void changeAirCompany(AirCompanyDTO airCompanyDTO) throws InvalidObjectException;

    void deleteAirCompany(Integer id);

    AirCompanyDTO getAirCompanyById(int id);

    List<AirCompanyDTO> getAllAirCompanies();
}
