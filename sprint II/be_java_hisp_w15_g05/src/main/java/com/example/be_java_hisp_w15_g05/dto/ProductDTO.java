package com.example.be_java_hisp_w15_g05.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
