package com.be.java.hisp.w156.be.java.hisp.w156.dto;

import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import com.be.java.hisp.w156.be.java.hisp.w156.model.PromoPost;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class ResponsePromoPostDTO extends ResponsePostDTO{
    private boolean has_promo;
    private double discount;

    public ResponsePromoPostDTO(Integer post_id, String date, Product detail, String category, Double price, boolean has_promo, double discount) {
        super(post_id, date, detail, category, price);
        this.has_promo = has_promo;
        this.discount = discount;
    }

    public static ResponsePromoPostDTO from(PromoPost promoPost) {
        String date = LocalDate.from(promoPost.getDate()).toString();
        return new ResponsePromoPostDTO(promoPost.getId(),
                                        date,
                                        promoPost.getDetail(),
                                        promoPost.getCategory(),
                                        promoPost.getPrice(),
                                        promoPost.isHas_promo(),
                                        promoPost.getDiscount());
    }
}
