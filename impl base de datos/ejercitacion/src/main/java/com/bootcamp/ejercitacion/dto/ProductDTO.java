package com.bootcamp.ejercitacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String id;
    private String name;
    private String type;
    private Double sale;
    private Double cost;
    private Integer quantity;
}
