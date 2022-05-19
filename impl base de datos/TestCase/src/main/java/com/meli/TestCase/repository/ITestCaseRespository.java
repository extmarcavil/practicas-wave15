package com.meli.TestCase.repository;

import com.meli.TestCase.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRespository extends JpaRepository<TestCase,Long> {

    List<TestCase> findByLastUpdateAfter(LocalDate lastUpdate);
}
