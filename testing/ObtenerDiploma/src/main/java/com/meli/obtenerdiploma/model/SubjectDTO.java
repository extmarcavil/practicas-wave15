package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {

    @NotEmpty(message = "El nombre del alumno no puede estar vacio.")
    @Pattern(regexp = "[A-Z].*", message = "El nombre de la materia debe comenzar con letra mayuscula.")
    @Size(min = 3, max= 30, message= "El nombre del alumno debe tener una longitud maxima de 30 caracteres.")
    String name;

    @NotNull(message = "El campo puntaje no puede estar vacio.")
    @Min(value = 0, message= "El puntaje no puede ser menor a cero.")
    @Max(value = 10, message= "El puntaje no puede ser mayor a diez.")
    Double score;
}
