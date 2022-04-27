package com.example.be_java_hisp_w15_g07.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {
    private Integer productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

}

