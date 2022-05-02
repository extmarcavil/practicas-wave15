package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "El nombre no puede estar vacio")
    @Size(max=30, message = "El nombre no puede tener mas de 50 caracteres")
    String name;
    @NotEmpty(message = "El score no puede estar vacio")
    @Size(min=0,max=10, message = "El score debe ser mayor a 0 y menor a 10")
    Double score;
}
