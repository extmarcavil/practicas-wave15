package com.meli.obtenerdiploma.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ErrorDTO {
    private String name;
    private String description;
}
