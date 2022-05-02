package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter @Setter
public class SubjectDTO {

    @NotBlank (message = "La materia debe tener un nombre")
    String name;

    @PositiveOrZero (message = "La nota no puede ser negativa")
    Double score;
}
