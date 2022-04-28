package com.be.java.hisp.w156.be.java.hisp.w156.vitale.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponsePromoPostDTO extends ResponsePostDTO{

    private boolean has_promo;
    private Double discount;

    public String showProductName() {
        return this.getDetail().getProduct_name();
    }
}
