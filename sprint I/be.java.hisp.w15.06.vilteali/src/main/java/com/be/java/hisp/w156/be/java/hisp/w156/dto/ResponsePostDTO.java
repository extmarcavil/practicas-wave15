package com.be.java.hisp.w156.be.java.hisp.w156.dto;

import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class ResponsePostDTO {

    private Integer post_id;
    private LocalDate date;
    private Product detail;
    private String category;
    private Double price;
    private Double priceDiscount;
    private boolean has_promo;
    private Double discount;

    public static ResponsePostDTO from(Post post) {
        return new ResponsePostDTO(post.getId(),
                post.getDate(),
                post.getDetail(),
                post.getCategory(),
                post.getPrice(),
                post.getPriceDiscount(),
                post.isHas_promo(),
                post.getDiscount());
    }
}
