package com.exampleDos.baseDeDatos.repository;

import com.exampleDos.baseDeDatos.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Long> {
}
