package com.shymoniak.test_app.entity.enums;

import lombok.Getter;

@Getter
public enum CompanyType {
    INTERNATIONAL_AIRLINES("International Airlines"),
    NATIONAL_AIRLINES("National Airlines"),
    REGIONAL_AIRLINES("Regional Airlines");

    private String type;

    CompanyType(String type) {
        this.type = type;
    }
}
