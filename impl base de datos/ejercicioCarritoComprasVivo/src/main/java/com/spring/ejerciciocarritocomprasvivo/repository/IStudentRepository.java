package com.spring.ejerciciocarritocomprasvivo.repository;

import com.spring.ejerciciocarritocomprasvivo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
}
