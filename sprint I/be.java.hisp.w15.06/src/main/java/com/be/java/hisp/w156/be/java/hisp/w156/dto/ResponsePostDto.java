package com.be.java.hisp.w156.be.java.hisp.w156.dto;

import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class ResponsePostDto {

    private Integer post_id;
    private String date;
    private Product detail;
    private String category;
    private Double price;

    public static ResponsePostDto from(Post post) {
        String date = LocalDate.from(post.getDate()).toString();
        return new ResponsePostDto(post.getId(), date, post.getDetail(), post.getCategory(), post.getPrice());
    }
}
