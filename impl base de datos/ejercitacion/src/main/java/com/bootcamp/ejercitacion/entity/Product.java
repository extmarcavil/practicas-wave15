package com.bootcamp.ejercitacion.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "product")
public class Product {
    @Id
    private String id;
    private String name;
    private String type;
    private Double sale;
    private Double cost;
    private Integer quantity;
}
