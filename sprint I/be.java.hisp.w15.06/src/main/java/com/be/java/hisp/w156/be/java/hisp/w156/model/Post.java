package com.be.java.hisp.w156.be.java.hisp.w156.model;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.PostDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor(force = true) // Genera constructor sin parámetros.
@AllArgsConstructor
@Getter
@Setter
public class Post {

    private Integer id;
    //@JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private String date;
    private Product detail;
    private String category;
    private Double price;

    //Para el mapeo.
    public static Post from(PostDTO post) {
        return new Post(null, "", post.getDetail(), post.getCategory(), post.getPrice());
    }
}
