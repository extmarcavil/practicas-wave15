package com.meli.relaciones.dto;

import com.meli.relaciones.entities.Course;
import lombok.Data;

import java.util.Set;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private Set<CourseDto> courses;

}
