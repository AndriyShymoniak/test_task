package com.shymoniak.testapp.repository;

import com.shymoniak.testapp.entity.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCompanyRepository extends JpaRepository<AirCompany, Integer> {
}
