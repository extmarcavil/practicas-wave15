package com.sprint.be_java_hisp_w15_g10.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + post_id +
                ", detail=" + detail +
                ", date=" + date +
                ", category=" + category +
                ", price=" + price +
                ", has_promo=" + has_promo +
                ", discount=" + discount +
                '}';
    }
}
