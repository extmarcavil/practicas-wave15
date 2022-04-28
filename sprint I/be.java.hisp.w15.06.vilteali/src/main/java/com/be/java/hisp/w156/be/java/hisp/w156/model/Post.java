package com.be.java.hisp.w156.be.java.hisp.w156.model;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class Post {

    private Integer id;
    private LocalDate date;
    private Product detail;
    private String category;
    private Double price;
    private Double priceDiscount;
    private boolean has_promo;
    private Double discount;

    public static Post from(RequestPostDTO post) {
        if (post.isHas_promo()) {
            return createPostWithDiscount(post);
        }
        return new Post(post.getUser_id(),
                post.getDate(),
                post.getDetail(),
                post.getCategory(), post.getPrice(),
                null,
                false,
                null);
    }

    private static Post createPostWithDiscount(RequestPostDTO post) {
        double discount = post.getDiscount();
        double priceOriginal = post.getPrice();
        return new Post(post.getUser_id(),
                post.getDate(),
                post.getDetail(),
                post.getCategory(),
                priceOriginal,
                calculatePrice(priceOriginal, discount),
                true,
                discount
        );
    }

    private static double calculatePrice(Double price, Double discount) {
        return price - (price * discount / 100);
    }
}
