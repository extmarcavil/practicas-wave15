package com.example.hql_seguros_auto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plate;

    private String brand;

    private String model;

    private Integer fabricationYear;

    private Integer wheels;

    @OneToMany(mappedBy = "vehicle")
    private Set<Sinister> sinisters;
}
