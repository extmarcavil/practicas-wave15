package com.mercadolibre.bootcamp_api_deportistas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sport {
    private String name;
    private String level;
}
