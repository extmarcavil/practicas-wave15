package com.sprint1.be_java_hisp_w15_g4.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PromoCountDTO {
    private int user_id;
    private String user_name;
    private int promo_products_count;
}
