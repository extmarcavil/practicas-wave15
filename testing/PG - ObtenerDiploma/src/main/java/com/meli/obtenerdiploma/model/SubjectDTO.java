package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {

    @Pattern(regexp = "[A-Z].*", message = "El nombre de la materia debe comenzar con mayúscula.")
    @NotNull(message = "El nombre de la materia no puede estar vacío.")
    @Size(min = 1, max = 30, message = "La longitud del nombre no puede superar los 30 catacteres")
    String name;

    @NotNull(message = "El score no puede estar vacío.")
    @Min(value = 0, message = "La nota mínima debe ser 0.")
    @Max(value = 10, message = "La nota máxima debe ser 10.")
    Double score;
}
