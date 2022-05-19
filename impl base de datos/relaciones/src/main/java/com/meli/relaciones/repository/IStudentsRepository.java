package com.meli.relaciones.repository;

import com.meli.relaciones.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentsRepository extends JpaRepository<Student, Long> {
}
