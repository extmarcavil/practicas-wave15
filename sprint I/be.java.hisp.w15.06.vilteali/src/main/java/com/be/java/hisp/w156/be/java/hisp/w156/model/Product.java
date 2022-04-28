package com.be.java.hisp.w156.be.java.hisp.w156.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {

    private Integer id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
