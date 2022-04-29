package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "El nombre de la materia no puede estar vacío")
    @Pattern(regexp = "[A-Z][a-zA-Z]+", message = "El nombre de la materia debe comenzar con mayúscula.")
    @Size(max = 30 , message = "La longitud del nombre no puede superar los 30 caracteres")
    String name;

    @NotEmpty(message = "La nota no puede estar vacía")
    @Max(value = 10, message = "La máxima nota es 0.0")
    @Min(value = 0, message = "La mínima nota es 0.0")
    Double score;
}
