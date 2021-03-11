package com.shymoniak.testapp.service;

import com.shymoniak.testapp.domain.AirplaneDTO;

import java.io.InvalidObjectException;

public interface AirplaneService {
    void addAirplane(AirplaneDTO airplaneDTO) throws InvalidObjectException;

    void moveToAnotherAirCompany(Integer airplaneId, Integer airCompanyId);
}
