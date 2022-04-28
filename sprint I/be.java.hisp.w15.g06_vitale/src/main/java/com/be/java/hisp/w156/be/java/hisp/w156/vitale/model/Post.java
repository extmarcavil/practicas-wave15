package com.be.java.hisp.w156.be.java.hisp.w156.vitale.model;

import com.be.java.hisp.w156.be.java.hisp.w156.vitale.dto.request.RequestPostDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {

    private Integer post_id;
    private LocalDate date;
    private Product detail;
    private String category;
    private Double price;
    private boolean has_promo;
    private Double discount;

    public static Post from(RequestPostDTO post) {
        return new Post(post.getUser_id(), post.getDate(), post.getDetail(), post.getCategory(), post.getPrice(), false, 0.0);
    }
}
