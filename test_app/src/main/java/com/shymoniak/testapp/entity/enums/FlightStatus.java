package com.shymoniak.testapp.entity.enums;

import lombok.Getter;

@Getter
public enum FlightStatus {
    ACTIVE("ACTIVE"), COMPLETED("COMPLETED"),
    DELAYED("DELAYED"), PENDING("PENDING");

    private String status;

    FlightStatus(String status) {
        this.status = status;
    }
}
