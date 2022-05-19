package com.meli.relaciones.dto;

import lombok.Data;

import java.util.Set;

@Data
public class StudentDto {
    private String name;
    private Long id;
    private Set<CourseDto> courses;
}
