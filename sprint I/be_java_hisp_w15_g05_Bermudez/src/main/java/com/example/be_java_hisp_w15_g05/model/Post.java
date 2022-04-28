package com.example.be_java_hisp_w15_g05.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private int userId;
    private int postId;
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;

}
