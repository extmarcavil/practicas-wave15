package com.example.be_java_hisp_w15_g05.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;


public class PostPromotionDTO {

    private int postId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO detail;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;
}
