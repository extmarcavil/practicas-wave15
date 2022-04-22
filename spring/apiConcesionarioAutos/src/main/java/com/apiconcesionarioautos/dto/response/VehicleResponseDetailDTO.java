package com.apiconcesionarioautos.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class VehicleResponseDetailDTO {
    private String brand;
    private String model;
    private Date manufaturingDate;
    private double numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<ServiceResponseDTO> services;

    public VehicleResponseDetailDTO() {
    }

    public VehicleResponseDetailDTO(String brand, String model, Date manufaturingDate, double numberOfKilometers, int doors, double price, String currency, List<ServiceResponseDTO> services) {
        this.brand = brand;
        this.model = model;
        this.manufaturingDate = manufaturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
    }
}
