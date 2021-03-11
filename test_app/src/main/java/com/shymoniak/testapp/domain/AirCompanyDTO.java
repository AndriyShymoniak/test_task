package com.shymoniak.testapp.domain;

import com.shymoniak.testapp.entity.enums.CompanyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AirCompanyDTO {
    private int id;
    private String airCompanyName;
    private Date foundedAt;
    private CompanyType companyType;
}
