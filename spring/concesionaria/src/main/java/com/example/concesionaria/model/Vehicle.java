package com.example.concesionaria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private int id;

    private String brand;

    private String model;

    private LocalDate manufacturingDate;

    private int numberOfKilometers;

    private int doors;

    private double price;

    private String currency;

    private List<Service> services;

    private int countOfOwners;

    public boolean isBetweenDates(LocalDate since, LocalDate to){
        return this.manufacturingDate.isAfter(since) && this.manufacturingDate.isBefore(to);
    }

    public boolean isBetweenPrices(double since, double to) {
        return this.price > since && this.price < to;
    }
}
