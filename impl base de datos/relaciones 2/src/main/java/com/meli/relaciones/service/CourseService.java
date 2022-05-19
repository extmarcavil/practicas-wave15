package com.meli.relaciones.service;

import com.meli.relaciones.dto.CourseDTO;
import com.meli.relaciones.entities.Course;

public interface CourseService {
    Course save(Course course);
    CourseDTO getCourse(Long id);
}
