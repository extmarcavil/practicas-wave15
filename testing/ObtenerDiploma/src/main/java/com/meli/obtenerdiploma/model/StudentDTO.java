package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @Length(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    @NotBlank(message = "El nombre del estudiante no puede estar vacío.")
    @Pattern(regexp="[A-Z][a-z]*", message = "El nombre del estudiante debe comenzar con mayúscula.")
    String studentName;

    String message;

    Double averageScore;

    @NotEmpty(message = "La lista no puede ser vacía")
    List< @Valid SubjectDTO> subjects;
}
