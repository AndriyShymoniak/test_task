package com.shymoniak.test_app.entity;

import com.shymoniak.test_app.entity.enums.FlightStatus;
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

    @Column(name = "distance")
    private int distance;

    @Column(name = "air_company_id")
    private int airCompanyId;

    @Column(name = "airplaneId")
    private int airplane_id;

    @Column(name = "departure_country", length = 30)
    private String departureCountry;

    @Column(name = "destination_country", length = 30)
    private String destinationCountry;

    @Column(name = "ended_at")
    private Date endedAt;

    @Column(name = "delay_started_at")
    private Date delayStartedAt;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "flight_status", length = 30)
    @Enumerated(EnumType.STRING)
    private FlightStatus flightStatus;
}
