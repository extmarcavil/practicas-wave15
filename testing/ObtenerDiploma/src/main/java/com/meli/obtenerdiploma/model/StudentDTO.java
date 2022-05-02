package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotBlank (message = "El estudiante debe tener un nombre")
    String studentName;

    @NotNull(message = "El mensaje no puede ser nulo")
    String message;

    @PositiveOrZero (message = "El promedio no puede ser negativo")
    Double averageScore;

    @NotEmpty (message = "Deben agregarse materias al alumno")
    List<SubjectDTO> subjects;
}
