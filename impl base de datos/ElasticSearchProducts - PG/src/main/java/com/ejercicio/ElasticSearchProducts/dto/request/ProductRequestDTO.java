package com.ejercicio.ElasticSearchProducts.dto.request;

import lombok.Data;

@Data
public class ProductRequestDTO {

    private String name;
    private String type;
    private Double salePrice;
    private Double cost;
    private Integer quantity;
}
