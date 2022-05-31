package com.spring.ejerciciocarritocomprasvivo.repository;

import com.spring.ejerciciocarritocomprasvivo.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
}
