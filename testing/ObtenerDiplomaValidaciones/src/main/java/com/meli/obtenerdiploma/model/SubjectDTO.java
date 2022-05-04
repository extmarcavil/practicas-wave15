package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {

    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "^[A-Z]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)", message = "El nombre de la materia debe comenzar con mayúscula.")
    private String name;

    @NotNull(message = "La nota no puede estar vacía.")
    @Min(value = (long) 0.0, message = "La mínima nota es 0.0.")
    @Max(value = (long) 10.0, message = "La máxima nota es 10.0.")
    private Double score;
}
