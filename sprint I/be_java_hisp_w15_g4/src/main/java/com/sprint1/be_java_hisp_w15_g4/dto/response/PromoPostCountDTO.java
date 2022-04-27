package com.sprint1.be_java_hisp_w15_g4.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PromoPostCountDTO {
    private int user_id;
    private String user_name;
    private int promo_products_count;
}
