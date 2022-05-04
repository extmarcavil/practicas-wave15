package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "El nombre del alumno no puede estar vacío")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    @Pattern(regexp = "^[A-Z]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)", message = "El nombre del alumno debe comenzar con mayúscula")
    private String studentName;

    private String message;
    private Double averageScore;

    @NotNull(message = "La lista no puede ser vacía")
    private List<@Valid SubjectDTO> subjects;
}
