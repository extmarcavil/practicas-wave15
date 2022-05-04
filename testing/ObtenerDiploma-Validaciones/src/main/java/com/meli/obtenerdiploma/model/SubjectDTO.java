package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Getter
@Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Pattern(regexp = "[A-Z]\\w*", message = "El nombre de la materia debe comenzar con mayúscula.")
    @Length(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    String name;
    @NotNull(message = "La nota no puede estar vacía")
    @DecimalMin(value = "0.0", message = "La mínima nota es 0.0.")
    @DecimalMax(value = "10.0", message = "La máxima nota es 10.0.")
    Double score;
}
