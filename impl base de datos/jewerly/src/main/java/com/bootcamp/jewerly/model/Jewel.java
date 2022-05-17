package com.bootcamp.jewerly.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long identification_num;
    private String name;
    private String material;
    private Double weight;
    private String particularity;
    private Boolean owns_stone;
    private Boolean saleOrNot;

}
