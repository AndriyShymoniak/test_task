package com.shymoniak.test_app.repository;

import com.shymoniak.test_app.entity.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCompanyRepository extends JpaRepository<AirCompany, Integer> {
}
