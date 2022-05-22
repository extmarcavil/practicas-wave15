package com.meli.MiniSeries.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Double rating;
    private int amount_of_awards;

    public MiniSerie(String name, Double rating, int amount_of_awards) {
        this.name = name;
        this.rating = rating;
        this.amount_of_awards = amount_of_awards;
    }
}