package com.be.java.hisp.w156.be.java.hisp.w156.model;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPromoPostDTO;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class PromoPost extends Post{
    private boolean has_promo;
    private double discount;

    public PromoPost (Integer id, LocalDate date, Product detail, String category, Double price, boolean has_promo, double discount) {
        super(id, date, detail, category, price);
        this.has_promo = has_promo;
        this.discount = discount;
    }

    public static PromoPost from(RequestPromoPostDTO promoPost) {
        return new PromoPost(promoPost.getUser_id(),
                             promoPost.getDate(),
                             promoPost.getDetail(),
                             promoPost.getCategory(),
                             promoPost.getPrice(),
                             promoPost.isHas_promo(),
                             promoPost.getDiscount());
    }

}
