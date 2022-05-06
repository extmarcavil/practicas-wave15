package com.bootcamp.concesionaria.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@JsonSerialize
@AllArgsConstructor
@Getter
@Setter
public class Service implements Serializable {

    /**
     * Atributos
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Long kilometers;
    private String descriptions;
}
