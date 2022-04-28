package com.be.java.hisp.w156.be.java.hisp.w156.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CantPromoPostDTO {
    private final Integer user_id;
    private final String user_name;
    private final Integer promo_products_count;

    public static CantPromoPostDTO from(Integer id, String name, Integer cant) {
        return new CantPromoPostDTO(id, name, cant);
    }

}
