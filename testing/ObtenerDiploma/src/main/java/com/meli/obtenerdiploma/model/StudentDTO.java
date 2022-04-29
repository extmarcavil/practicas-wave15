package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    @NotNull(message = "El nombre del alumno no puede ser null.")
    @Size(min = 0,max = 50,message = "La longitud del nombre no puede superar los 50 caracteres.")
    @Pattern(regexp = "\\b([A-Z]\\w*)\\b",message = "El nombre del alumno debe comenzar con mayúscula.")
    String studentName;
    String message;
    Double averageScore;
    @Size(min = 1,message = "La lista no puede ser vacia")
     List<@Valid SubjectDTO> subjects;
}
