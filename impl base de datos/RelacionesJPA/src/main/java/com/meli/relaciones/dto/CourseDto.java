package com.meli.relaciones.dto;

import com.meli.relaciones.entities.Student;
import lombok.Data;

import java.util.Set;

@Data
public class CourseDto {
    private Long id;
    private Set<StudentDto> studentDtos;
}
