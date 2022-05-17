package com.example.ejemplo_jpa.repository;

import com.example.ejemplo_jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {



}
