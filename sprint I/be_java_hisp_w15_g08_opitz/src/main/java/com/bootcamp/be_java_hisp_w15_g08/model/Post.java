package com.bootcamp.be_java_hisp_w15_g08.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
    private int post_id;
    private LocalDate date;
    private PostDetail detail;
    private int category;
    private double price;
}
