package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "No puede estar vacio")
    @Length(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    @Pattern(regexp="[A-Z][a-z]*", message = "El nombre de la materia debe comenzar con mayúscula.")
    String name;

    @Max(value = 10,message = "La máxima nota es 10.0")
    @Min(value = 0, message = "La mínima nota es 0.0")
    Double score;
}
