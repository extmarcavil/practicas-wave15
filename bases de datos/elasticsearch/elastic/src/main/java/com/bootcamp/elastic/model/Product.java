package com.bootcamp.elastic.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

@Data
@Document(indexName = "product")
public class Product {
    @Id
    private String id;
    private String name;
    private String type;
    private BigDecimal priceSell;
    private BigDecimal priceCost;
    private Integer quantity;
}
