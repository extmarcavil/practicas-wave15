package com.sprint.be_java_hisp_w15_g10.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Post {
    private int post_id;
    private Product detail;
    private LocalDate date;
    private Category category;
    private double price;
    private boolean has_promo;
    private double discount;

    public Post(){
        has_promo = false;
        discount = 0.0;
    }
}
