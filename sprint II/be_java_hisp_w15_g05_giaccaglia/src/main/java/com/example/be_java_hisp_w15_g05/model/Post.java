package com.example.be_java_hisp_w15_g05.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post {

    private int userId;
    private int postId;
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;

}
