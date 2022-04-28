package com.be.java.hisp.w156.be.java.hisp.w156.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePromoPostDTO implements Serializable {

    private Integer user_id;
    private String  user_name;
    private int     promo_products_count;

}
