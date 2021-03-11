package com.shymoniak.testapp.entity;

import com.shymoniak.testapp.entity.enums.FlightStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "distance", nullable = false)
    private int distance;

    @Column(name = "air_company_id", nullable = false)
    private int airCompanyId;

    @Column(name = "airplane_id", nullable = false)
    private int airplaneId;

    @Column(name = "departure_country", length = 30, nullable = false)
    private String departureCountry;

    @Column(name = "destination_country", length = 30, nullable = false)
    private String destinationCountry;

    @Column(name = "ended_at")
    private Date endedAt;

    @Column(name = "delay_started_at")
    private Date delayStartedAt;

    @Column(name = "started_at")
    private Date startedAt;

    @Column(name = "flight_status", length = 30)
    @Enumerated(EnumType.STRING)
    private FlightStatus flightStatus;
}
