package com.example.edadDeUnaPersona.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
public class BornDTO implements Serializable {
    //este DTO indica cómo tiene que ser el body que recibimos
    private Integer day;
    private Integer month;
    private Integer year;

    //indicamos en qué formato vamos a recibir la variable "born"
    @JsonFormat(pattern="dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate born;

}
