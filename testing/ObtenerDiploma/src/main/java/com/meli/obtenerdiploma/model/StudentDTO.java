package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter @Valid
public class StudentDTO {

    @NotNull(message = "El campo no puede estar vacío")
    @Size(max = 50, message = "No puede tener más de 50 caracteres")
    String studentName;


    String message;
    Double averageScore;


    @NotEmpty(message = "No puede estar vacía")
    List<SubjectDTO> subjects;
}
