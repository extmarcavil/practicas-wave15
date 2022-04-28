package com.example.be_java_hisp_w15_g07.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PromoCountDTO {

    private Integer userId;
    private String userName;
    private Integer promoCount;
}
