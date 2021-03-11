package com.shymoniak.testapp.repository;

import com.shymoniak.testapp.entity.Flight;
import com.shymoniak.testapp.entity.enums.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    @Query(value = "SELECT * FROM flight f " +
                    "INNER JOIN air_company ac ON ac.id=f.air_company_id " +
                    "WHERE ac.air_company_name=:airCompanyName " +
                    "AND f.flight_status=:flightStatus",
            nativeQuery = true)
    List<Flight> findAllByNameAndStatus(@Param("airCompanyName") String airCompanyName,
                                        @Param("flightStatus") String flightStatus);

    @Query(value = "SELECT * FROM flight f WHERE f.flight_status='COMPLETED'" +
                   "AND f.ended_at-f.started_at>:estimated",
            nativeQuery = true)
    List<Flight> findAllCompletedWithLongerFlightTime(@Param("estimated") Date estimated);

    List<Flight> findAllByFlightStatusAndStartedAtBefore(FlightStatus status,
                                                         Date date);
}

