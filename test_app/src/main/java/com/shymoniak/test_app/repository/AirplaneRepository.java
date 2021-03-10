package com.shymoniak.test_app.repository;

import com.shymoniak.test_app.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {
}
