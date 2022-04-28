package com.be.java.hisp.w156.be.java.hisp.w156.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PostCountPromoDTO {

    private Integer user_id;
    private String user_name;
    private Integer promo_products_count;
}
