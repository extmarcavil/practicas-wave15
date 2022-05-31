package com.mercadolibre.bootcamp_api_deportistas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String  name;
    private String  surname;
    private String  sportName;
    private int     age;
}
