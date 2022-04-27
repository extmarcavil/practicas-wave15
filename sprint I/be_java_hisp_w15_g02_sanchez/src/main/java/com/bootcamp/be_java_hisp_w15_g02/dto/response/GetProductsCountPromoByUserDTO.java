package com.bootcamp.be_java_hisp_w15_g02.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductsCountPromoByUserDTO {
    private int user_id;
    private String user_name;
    private int promo_products_count;

    public GetProductsCountPromoByUserDTO() {
    }

    public GetProductsCountPromoByUserDTO(int user_id, String user_name, int promo_products_count) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.promo_products_count = promo_products_count;
    }
}
