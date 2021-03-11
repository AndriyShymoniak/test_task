package com.shymoniak.testapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "airplane")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "number_of_flights", nullable = false)
    private int numberOfFlights;

    @Column(name = "flight_distance", nullable = false)
    private int flightDistance;

    @Column(name = "fuel_capacity", nullable = false)
    private int fuelCapacity;

    @Column(name = "air_company_id")
    private int airCompanyId;

    @Column(name = "airplane_name", length = 30, nullable = false)
    private String airplaneName;

    @Column(name = "factory", length = 30, nullable = false)
    private String factory;

    @Column(name = "serial_number", length = 10, nullable = false)
    private String serialNumber;

    @Column(name = "airplane_type", length = 100, nullable = false)
    private String airplaneType;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;
}
