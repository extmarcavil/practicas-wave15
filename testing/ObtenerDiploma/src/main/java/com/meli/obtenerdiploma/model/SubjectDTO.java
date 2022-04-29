package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "El nombre de la materia no puede estar vacío.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "/^[A-Z][a-z0-9_-]$/", message = "El nombre de la materia debe comenzar con mayúscula.")
     String name;
    @NotEmpty(message = "La nota no puede estar vacía.")
    @Min(value = 0, message = "la minima nota es 0.0")
    @Max(value = 10,message = "La máxima nota es 10.0")
    Double score;
}
