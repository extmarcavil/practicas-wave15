package com.sprint1.be_java_hisp_w15_g03.dto.response;

import com.sprint1.be_java_hisp_w15_g03.dto.PersonDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PromoCountDT0 extends PersonDTO {

    private int promo_products_count;

    public PromoCountDT0(Integer userId, String userName, int promo_products_count) {
        super(userId, userName);
        this.promo_products_count = promo_products_count;
    }
}
