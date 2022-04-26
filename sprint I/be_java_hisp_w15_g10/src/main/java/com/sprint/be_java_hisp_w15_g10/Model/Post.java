package com.sprint.be_java_hisp_w15_g10.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private Product detail;
    private Date date;
    private Category category;
    private double price;
    private boolean has_promo;
    private double discount;
}
