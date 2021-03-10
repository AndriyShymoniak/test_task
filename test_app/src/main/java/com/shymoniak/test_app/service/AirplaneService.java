package com.shymoniak.test_app.service;

import com.shymoniak.test_app.domain.AirplaneDTO;

public interface AirplaneService {
    void moveToAnotherAirCompany(Integer airplaneId, Integer airCompanyId);
    void addAirplane(AirplaneDTO airplaneDTO);
}
