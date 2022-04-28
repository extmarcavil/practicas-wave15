package com.bootcamp.be_java_hisp_w15_g02.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetPostCountDTO {
    private int userId;
    private String userName;
    private int promoProductsCount;

    public GetPostCountDTO() {
    }

    public GetPostCountDTO(int userId, String userName, int promoProductsCount) {
        this.userId = userId;
        this.userName = userName;
        this.promoProductsCount = promoProductsCount;
    }
}
