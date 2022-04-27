package com.sprint1.be_java_hisp_w15_g4.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.Period;

@Setter
@Getter
public class Post {
    private static AtomicInteger idSequence = new AtomicInteger();
    private int user_id;
    private int post_id;
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;


    public Post(){
        this.post_id = idSequence.incrementAndGet();
    }

    public boolean ultimas2Semanas() {
        Period periodo = Period.between(date, LocalDate.now());
        return periodo.getDays() <= 14;
    }


}
