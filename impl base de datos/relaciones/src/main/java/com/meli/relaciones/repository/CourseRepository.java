package com.meli.relaciones.repository;

import com.meli.relaciones.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
