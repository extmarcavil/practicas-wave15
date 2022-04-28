package com.be.java.hisp.w156.be.java.hisp.w156.dto;

import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ResponsePostPromoDTO extends ResponsePostDTO{

    private Boolean has_promo;
    private Double discount;

    public ResponsePostPromoDTO(Integer post_id, String date, Product detail, String category, Double price, Boolean has_promo, Double discount) {
        super(post_id, date, detail, category, price);
        this.has_promo = has_promo;
        this.discount = discount;
    }

    public static ResponsePostPromoDTO from(Post post) {
        String date = LocalDate.from(post.getDate()).toString();
        return new ResponsePostPromoDTO(post.getId(), date, post.getDetail(), post.getCategory(), post.getPrice(), post.getHas_promo(), post.getDiscount());
    }

}
