package com.meli.TestCase.repository;

import com.meli.TestCase.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.LocalDate;

@Repository
public interface ITestCaseRespository extends JpaRepository<TestCase,Long> {

    List<TestCase> findAllByLastUpdateAfter(LocalDate lastUpdate);
}
