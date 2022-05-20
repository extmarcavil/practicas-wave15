package com.meli.TestCase.repository;

import com.meli.TestCase.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRespository extends JpaRepository<TestCase,Long> {
    @Query("SELECT t FROM TestCase t WHERE t.lastUpdate > ?1")
    List<TestCase> findAllByDateAfter(LocalDate last_updated);
}
