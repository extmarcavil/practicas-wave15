package com.be.java.hisp.w156.be.java.hisp.w156.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Product {

    private Integer id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
