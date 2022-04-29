package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "Campo nombre de la asignatura no puede ser nulo.")
    @Pattern(regexp= "[A-Z].*", message = "Debe comenzar con mayuscula")
    @Size(min=0,max=30,message = "El nombre de la asignatura no debe tener mas de 30 caracteres")
    String name;

    @NotNull(message = "El score no puede ser nulo")
    @DecimalMin(value = "0.0",message = "El score debe estar entre 0 y 10")
    @DecimalMax(value = "10.0",message = "El score debe estar entre 0 y 10")
    Double score;
}
