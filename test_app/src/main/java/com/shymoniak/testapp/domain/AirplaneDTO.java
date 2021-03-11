package com.shymoniak.testapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AirplaneDTO {
    private int id;
    private int numberOfFlights;
    private int flightDistance;
    private int fuelCapacity;
    private int airCompanyId;
    private String airplaneName;
    private String factory;
    private String serialNumber;
    private String airplaneType;
    private Date createdAt;
}
