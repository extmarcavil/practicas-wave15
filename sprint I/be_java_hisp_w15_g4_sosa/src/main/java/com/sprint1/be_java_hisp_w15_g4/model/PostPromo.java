package com.sprint1.be_java_hisp_w15_g4.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class PostPromo {
    private int user_id;
    private static AtomicInteger idSequence = new AtomicInteger();
    private int post_id;
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;

    public PostPromo(){
        this.post_id = idSequence.incrementAndGet();
    }
}
