package com.bootcamp.elastic.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private String id;
    private String name;
    private String type;
    private BigDecimal priceSell;
    private BigDecimal priceCost;
    private Integer quantity;
}
