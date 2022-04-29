package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotNull(message = "El nombre del alumno no puede estar vacío")
    @Pattern(regexp = "[A-Z][a-zA-Z]+", message = "El nombre del alumno debe comenzar con mayúscula")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    String studentName;
    String message;
    Double averageScore;

    @NotEmpty(message = "La lista no puede ser vacía")
    List<SubjectDTO> subjects;
}
