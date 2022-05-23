package com.bootcamp.consecionariahql.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String patent;
    private String brand;
    private String model;
    private int fabricationYear;
    private int amountOfTires;

    @OneToMany(mappedBy = "vehicle")
    private Set<Crash> crashes;

}

