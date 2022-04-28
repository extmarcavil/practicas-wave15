package com.sprint1.be_java_hisp_w15_g4.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.Period;

@Setter
@Getter
public class Post {
    private int user_id;
    private static AtomicInteger idSequence = new AtomicInteger();
    private int post_id;
    private LocalDate date; //se obtiene en el momento LocalDate.now()
    private Product detail;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;

    public boolean ultimas2Semanas() {
        return !date.isBefore(LocalDate.now().minusDays(14));
    }

    public Post(){
        this.post_id = idSequence.incrementAndGet();
    }
}
