package com.example.springDataJPA.repository;

import com.example.springDataJPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
