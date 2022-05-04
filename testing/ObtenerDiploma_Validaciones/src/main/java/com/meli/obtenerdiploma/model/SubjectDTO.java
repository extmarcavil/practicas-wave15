package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
public class SubjectDTO {

    @NotEmpty(message = "El nombre de la materia no puede estar vacio")
    @Size(min = 0, max = 30 , message = "La longitud del nombre no puede superar los 30 caracteres")
    String name;

    @NotEmpty(message = "La nota no puede estar vacia")
    @Size(min = 0, max = 10, message = "La minima nota es 0 , La maxima nota es 10")
    Double score;
}
