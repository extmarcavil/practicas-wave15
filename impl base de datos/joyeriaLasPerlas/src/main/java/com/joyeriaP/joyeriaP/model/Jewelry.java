package com.joyeriaP.joyeriaP.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jewelry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long identity_number;
    String name;
    String material;
    float weight;
    String particularity;
    Boolean has_stone;
    Boolean isSelled;


}
