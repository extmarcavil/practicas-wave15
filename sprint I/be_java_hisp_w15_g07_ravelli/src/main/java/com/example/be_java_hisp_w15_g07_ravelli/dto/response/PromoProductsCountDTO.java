package com.example.be_java_hisp_w15_g07_ravelli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PromoProductsCountDTO {
    private Integer userId;
    private String userName;
    private Long promoProductsCount;

}
