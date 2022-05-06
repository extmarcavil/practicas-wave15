package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @Valid
        @NotEmpty(message = "El nombre de la materia no puede estar vacío.")
        @Pattern(regexp = "[A-Z].*", message = "El nombre de la materia debe comenzar con mayúscula.")
        @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    String name;
        @NotEmpty(message = "La nota no puede estar vacía.")
        @DecimalMin(value="0,0", inclusive=true, message = "La mínima nota es 0.0.")
        @Max(value=10, message="La máxima nota es 10.0.")
    Double score;
}
