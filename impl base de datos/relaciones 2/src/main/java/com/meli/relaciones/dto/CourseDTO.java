package com.meli.relaciones.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CourseDTO {
    private Long courseId;
    private List<StudentDTO> students;
}
