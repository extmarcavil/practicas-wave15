package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

//Uso lombok

@Getter
@Setter
public class BornDTO {
    Integer day;
    Integer month;
    Integer year;


    @JsonFormat(pattern = "dd/MM/yyyy",shape = JsonFormat.Shape.STRING)
    LocalDate born;
}
