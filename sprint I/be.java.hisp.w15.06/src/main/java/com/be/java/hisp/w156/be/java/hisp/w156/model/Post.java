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

    public static Post from(RequestPostDTO post) {
        return new Post(post.getUser_id(), post.getDate(), post.getDetail(), post.getCategory(), post.getPrice());
    }
}
