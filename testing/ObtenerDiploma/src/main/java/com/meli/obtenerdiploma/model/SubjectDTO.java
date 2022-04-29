package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "El nombre de la materia es obligatorio.")
    @Pattern(regexp = "[A-Z][a-zA-ZÀ-ÿ]+", message = "El nombre del alumno debe comenzar con mayúscula")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    String name;
    @NotNull(message = "La nota es obligatoria.")
    @DecimalMin("0.0")
    @DecimalMax("10.0")
    Double score;
}
