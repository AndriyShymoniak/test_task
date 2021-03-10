package com.shymoniak.test_app.domain;

import com.shymoniak.test_app.entity.enums.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {
    private int id;
    private int distance;
    private int airCompanyId;
    private int airplane_id;
    private String departureCountry;
    private String destinationCountry;
    private Date endedAt;
    private Date delayStartedAt;
    private Date startedAt;
    private FlightStatus flightStatus;
}
