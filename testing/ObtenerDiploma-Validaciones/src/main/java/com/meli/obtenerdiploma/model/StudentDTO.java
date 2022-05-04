package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
public class StudentDTO {
    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    @Length(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    @Pattern(regexp = "[A-Z]\\w*", message = "El nombre del alumno debe comenzar con mayúscula.")
    String studentName;
    String message;
    Double averageScore;

    @Valid
    @NotEmpty(message = "La lista no puede ser vacía.")
    List<SubjectDTO> subjects;
}
