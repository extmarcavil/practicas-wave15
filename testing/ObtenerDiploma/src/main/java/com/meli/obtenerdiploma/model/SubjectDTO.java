package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter @Valid
public class SubjectDTO {

    @NotBlank(message = "El nombre de la materia no puede estar vacío")
    @Size(max=30, message = "Caracteres máximos de la materia es de 30")
    String name;

    @NotBlank(message = "Tiene que tener un valor")
    @Min(value = 0, message = "La nota debe ser mínimamente de 0.0")
    @Max(value = 10, message = "La nota máxima es de 10.0")
    Integer score;
}
