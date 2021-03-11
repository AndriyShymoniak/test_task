package com.shymoniak.testapp.service;

import com.shymoniak.testapp.domain.AirplaneDTO;

public interface AirplaneService {
    void addAirplane(AirplaneDTO airplaneDTO);

    void moveToAnotherAirCompany(Integer airplaneId, Integer airCompanyId);
}
