package com.bootcamp.be_java_hisp_w15_g02.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetPromoPostCountDTO {
    private int userId;
    private String userName;
    private int promoProductsCount;

    public GetPromoPostCountDTO(int userId, String userName, int promoProductsCount) {
        this.userId = userId;
        this.userName = userName;
        this.promoProductsCount = promoProductsCount;
    }
}
