package com.example.be_java_hisp_w15_g05.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResPromoPostsDTO {

    private Integer userId;
    private String userName;
    private Integer promoProductsCount;

}
