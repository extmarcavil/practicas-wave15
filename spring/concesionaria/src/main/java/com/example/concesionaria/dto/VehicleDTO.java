package com.example.concesionaria.dto;

import com.example.concesionaria.model.Service;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class VehicleDTO {
    private String brand;

    private String model;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate manufacturingDate;

    private int numberOfKilometers;

    private int doors;

    private double price;

    private String currency;

    private List<Service> services;

    private int countOfOwners;
}
