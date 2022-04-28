package com.example.be_java_hisp_w15_g05.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResCountPromoPostDTO {

    private int user_id;
    private String user_name;
    private int promo_products_count;

}
