package com.miniseries.miniSeries.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_miniserie;
    private String name;
    private Double rating;
    private int amount_of_awards;

    public MiniSerie(String name, Double rating, int amount_of_awards) {
        this.name = name;
        this.rating = rating;
        this.amount_of_awards = amount_of_awards;
    }
}
