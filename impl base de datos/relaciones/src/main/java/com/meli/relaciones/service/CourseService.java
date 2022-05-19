package com.meli.relaciones.service;

import com.meli.relaciones.dto.CourseDto;
import com.meli.relaciones.dto.StudentDto;


public interface CourseService {
    StudentDto saveCourse(StudentDto studentDto);
}
