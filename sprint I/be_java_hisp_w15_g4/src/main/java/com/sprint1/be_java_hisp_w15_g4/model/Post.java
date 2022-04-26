package com.sprint1.be_java_hisp_w15_g4.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Setter
@Getter
public class Post {
    private int post_id;
    private LocalDate date; //se obtiene en el momento LocalDate.now()
    private Product detail;
    private int category;
    private double price;

    public boolean ultimas2Semanas() {
        Period periodo = Period.between(date, LocalDate.now());
        return periodo.getDays() <= 14;
    }
}
