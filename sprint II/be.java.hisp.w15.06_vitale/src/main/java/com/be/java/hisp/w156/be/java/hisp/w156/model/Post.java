package com.be.java.hisp.w156.be.java.hisp.w156.model;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.ui.ModelMap;

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

    public static Post from(RequestPostDTO post) {
        return new Post(post.getUser_id(), post.getDate(), Product.from(post.getDetail()), post.getCategory(), post.getPrice());
    }
}


