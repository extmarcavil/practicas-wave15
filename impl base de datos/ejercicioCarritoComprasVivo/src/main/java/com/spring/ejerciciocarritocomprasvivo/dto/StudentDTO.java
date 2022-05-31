package com.spring.ejerciciocarritocomprasvivo.dto;

import lombok.Data;

import java.util.Set;

@Data
public class StudentDTO {
    private Set<CourseDTO> courses;
}
