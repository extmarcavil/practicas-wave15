package com.bootcamp.be_java_hisp_w15_g08.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Promo {
    private int user_id;
    private LocalDate date;
    PostDetail detail;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;

}
