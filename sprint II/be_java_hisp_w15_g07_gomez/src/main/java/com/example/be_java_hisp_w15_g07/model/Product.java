package com.example.be_java_hisp_w15_g07.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Product {

    private Integer productId;

    private String productName;

    private String type;

    private String brand;

    private String color;

    private String notes;
}
