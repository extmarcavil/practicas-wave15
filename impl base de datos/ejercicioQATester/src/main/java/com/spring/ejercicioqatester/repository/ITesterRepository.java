package com.spring.ejercicioqatester.repository;

import com.spring.ejercicioqatester.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITesterRepository extends JpaRepository<TestCase, Long> {
}
