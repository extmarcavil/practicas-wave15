package com.testing.validations.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class StudentDTO {

    @NotBlank(message="El nombre del alumno no puede estar vacío")
    @Size(max=50, message="La longitud del nombre no puede superar los 50 caracteres")
    @Pattern(regexp="^[A-Z][a-zA-Z]*", message="El nombre del alumno debe comenzar con mayúscula")
    private String studentName;

    private String message;
    private Double averageScore;
    private List<SubjectDTO> subjects;
}
