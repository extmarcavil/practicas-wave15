package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    String message;
    @NotNull (message = "El nombre del estudiante no debe estar vacio")
    @Pattern(regexp = "[A-Z][a-zA-Z]+", message = "El nombre del alumno debe comenzar con mayúscula")
    String studentName;
    Double averageScore;

    @NotEmpty (message = "La lista no debe estar vacia")
    List<SubjectDTO> subjects;
}
