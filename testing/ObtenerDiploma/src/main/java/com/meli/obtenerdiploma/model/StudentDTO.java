package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
public class StudentDTO {
    @NotEmpty(message = "El nombre del alumno no puede estar vacio")
    @Pattern(regexp = "[A-Z](\\p{Alpha}||\\s)+", message = "El nombre del alumno debe comenzar con Mayuscula.")
    @Size(max = 50, message = "La longitud del nombre del alumno no puede superar los 50 caracteres")
    private String studentName;
    private String message;
    private Double averageScore;
    @NotNull
    @NotEmpty(message = "La lista no puede estar vacia")
    @Valid
    private List<SubjectDTO> subjects;
}
