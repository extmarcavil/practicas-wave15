package com.be.java.hisp.w156.be.java.hisp.w156.dto.response;

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

    public static ResponsePostDTO from(Post post) {
        return new ResponsePostDTO(post.getPost_id(), post.getDate(), post.getDetail(), post.getCategory(), post.getPrice());
    }
}
