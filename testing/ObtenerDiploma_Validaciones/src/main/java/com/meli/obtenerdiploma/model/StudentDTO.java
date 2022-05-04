package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class StudentDTO {
    @NotEmpty(message =  "El nombre del alumno no puede estar vacio")
    @Size(min = 0, max= 50, message ="La longitud del nombre no puede superar los 50 caracteres" )
    String studentName;

    String message;

    Double averageScore;

    @NotEmpty(message = "La ista no puede ser vacia")
    List<SubjectDTO> subjects;
}
