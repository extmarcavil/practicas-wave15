package com.be.java.hisp.w156.be.java.hisp.w156.model;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Getter
@Setter
public class Post {

    private static final DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private Integer id;
    private LocalDate date;
    private Product detail;
    private String category;
    private Double price;

    public static Post from(RequestPostDTO post) {
        LocalDate date = LocalDate.parse(post.getDate(), formatter);
        return new Post(post.getUser_id(), date, post.getDetail(), post.getCategory(), post.getPrice());
    }
}
