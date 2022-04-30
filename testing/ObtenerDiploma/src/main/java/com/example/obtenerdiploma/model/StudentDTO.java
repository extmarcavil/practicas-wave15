package com.example.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Setter
@Getter
public class StudentDTO {
    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    @Size(max = 50 , message = "Nombre debe menos de 50 caracteres.")
    @Pattern(regexp = "^[A-Z].*",message = "El nombre del alumno debe comenzar con mayúscula.")
    String studentName;

    String message;
    Double averageScore;
    @NotEmpty(message = "La lista no puede ser vacía.")
    List<@Valid SubjectDTO> subjects;

}
