package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "El nombre de la materia no puede estar vacío.")
    @NotNull(message = "El nombre de la materia no puede ser null.")
    @Size(min = 0 ,max = 30,message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "\\b([A-Z]\\w*)\\b",message = "El nombre de la materia debe comenzar con mayúscula.")
    String name;
    @DecimalMin(value ="0.0",message = "La mínima nota es 0.0.")
    @DecimalMax(value = "10.0",message = "La máxima nota es 10.0.")
     Double score;
}
