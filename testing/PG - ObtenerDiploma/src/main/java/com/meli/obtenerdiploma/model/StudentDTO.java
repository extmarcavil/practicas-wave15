package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @Pattern(regexp = "[A-Z].*", message = "El nombre del alumno debe comenzar con mayúscula.")
    @NotNull (message = "El nombre no puede estar vacío.")
    @Size (max = 50, message = "La longitud del nombre no puede superar los 50 catacteres")
    String studentName;

    String message;

    Double averageScore;

    @NotNull(message = "La lista no puede ser vacía.")
    List<@Valid SubjectDTO> subjects;
}
