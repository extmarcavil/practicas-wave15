package com.meli.relaciones.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    private Long id;
    private List<CourseDto> courses;
}
