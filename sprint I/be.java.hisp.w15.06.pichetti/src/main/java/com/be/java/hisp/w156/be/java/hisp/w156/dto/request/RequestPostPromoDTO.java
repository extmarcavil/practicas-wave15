package com.be.java.hisp.w156.be.java.hisp.w156.dto.request;

import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RequestPostPromoDTO extends RequestPostDTO{

    private boolean has_promo;
    private Double discount;

    public RequestPostPromoDTO(Integer user_id, LocalDate date, Product detail, String category, Double price, boolean has_promo, Double discount) {
        super(user_id, date, detail, category, price);
        this.has_promo = has_promo;
        this.discount = discount;
    }
}
