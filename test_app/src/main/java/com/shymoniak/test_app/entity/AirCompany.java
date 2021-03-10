package com.shymoniak.test_app.entity;

import com.shymoniak.test_app.entity.enums.CompanyType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "air_company")
public class AirCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "air_company_name", length = 30)
    private String airCompanyName;

    @Column(name = "founded_at")
    private Date foundedAt;

    @Column(name = "company_type", length = 30)
    @Enumerated(EnumType.STRING)
    private CompanyType companyType;
}
