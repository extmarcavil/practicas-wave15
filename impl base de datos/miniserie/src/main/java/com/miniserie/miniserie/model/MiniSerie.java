package com.miniserie.miniserie.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class MiniSerie {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    Double rating;
    int amount_of_awards;
}
