package com.spring.ejerciciocarritocomprasvivo.service;

import com.spring.ejerciciocarritocomprasvivo.dto.CourseDTO;
import com.spring.ejerciciocarritocomprasvivo.entities.Course;

public interface ICourseService {
    void saveCourse(CourseDTO courseDTO);
}
