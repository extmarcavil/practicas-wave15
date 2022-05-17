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
    @Modifying
    @Query("update TestCase u set u.passed = true where u.id = ?1")
    void updateInfoById(Long id);

    @Query("from TestCase u where u.lastUpdate between ?1 and :now")
    List<TestCase> findByDate(LocalDate last_update);
}
