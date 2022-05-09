package com.sprint.be_java_hisp_w15_g10.Model;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private int post_id;
    private Product detail;
    private LocalDate date;
    private Category category;
    private double price;
    private boolean has_promo;
    private double discount;


}
