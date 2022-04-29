package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotEmpty(message = "El nombre del alumno no pudede estar vacio.")
    @Pattern(regexp = "[A-Z].*", message = "El nombre del alumno debe comenzar con letra mayuscula.")
    @Size(min = 3, max= 50, message= "El nombre del alumno debe tener una longitud maxima de 50 caracteres.")
    String studentName;

    String message;

    Double averageScore;


    @NotEmpty(message = "La lista de materias no puede estar vacia.")
    List<@Valid SubjectDTO> subjects;
}
