package com.shymoniak.test_app.entity;

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

    @Column(name = "number_of_flights")
    private int numberOfFlights;

    @Column(name = "flight_distance")
    private int flightDistance;

    @Column(name = "fuel_capacity")
    private int fuelCapacity;

    @Column(name = "air_company_id")
    private int airCompanyId;

    @Column(name = "airplane_name", length = 30)
    private String airplaneName;

    @Column(name = "factory", length = 30)
    private String factory;

    @Column(name = "serial_number", length = 10)
    private String serialNumber;

    @Column(name = "airplane_type", length = 100)
    private String airplaneType;

    @Column(name = "created_at")
    private Date createdAt;
}
