package com.meli.joyeria.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter @Getter @Entity
public class Jewelry {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String material;
    private Double weight;
    private String particularity;
    private boolean has_stone;
    private boolean sell;

    public Jewelry(Long id, String name, String material, Double weight, String particularity, boolean has_stone, boolean sell) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.weight = weight;
        this.particularity = particularity;
        this.has_stone = has_stone;
        this.sell = true;
    }
}
