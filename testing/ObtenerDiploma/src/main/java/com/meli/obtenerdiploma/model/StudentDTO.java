package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotNull(message = "El nombre del estudiante no puede ser nulo")
    @NotBlank(message = "El nombre del estudiante no puede estar vacío.")
    @Pattern(regexp = "[A-Z][a-zA-Z]+", message = "El nombre del alumno debe comenzar con mayúscula")
    @Size(max=50, message = "Longitud máxima de 50 caracteres")
    String studentName;
    String message;
    Double averageScore;

    @NotNull(message = "La lista de materias no puede estar vacia")
    List<@Valid SubjectDTO> subjects;
}
