package com.apiconcesionarioautos.dto.request;

import com.apiconcesionarioautos.model.Service;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class VehicleRequestDTO {
    private String brand;
    private String model;
    private Date manufaturingDate;
    private double numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<ServiceRequestDTO> services;

    public VehicleRequestDTO(String brand, String model, Date manufaturingDate, double numberOfKilometers, int doors, double price, String currency, List<ServiceRequestDTO> services) {
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
