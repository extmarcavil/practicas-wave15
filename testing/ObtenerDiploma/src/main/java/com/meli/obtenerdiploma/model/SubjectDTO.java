package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {

    @NotNull(message = "El nombre de la materia no puede ser nullo")
    @NotEmpty(message = "El nombre de la materia no puede estar vacío.")
    @Pattern(regexp = "[A-Z].*", message = "El nombre de la materia debe comenzar con mayúscula")
    @Length(min = 1, max = 30, message = "Longitud máxima de 30 caracteres")
    String name;

    @NotNull(message = "El puntaje no puede ser vacio")
    @DecimalMax(value ="10.0", message = "La máxima nota es 10.0")
    @DecimalMin(value ="0.0", message = "La mínima nota es 0.0")
    Double score;
}
