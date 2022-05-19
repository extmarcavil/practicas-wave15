package com.meli.relaciones.dto;

import com.meli.relaciones.entities.Student;
import lombok.Data;

import java.util.Set;

@Data
public class CourseDtoResp {
    private Long id;
    private String name;
    private Set<StudentDtoSinCurso> std;

}
