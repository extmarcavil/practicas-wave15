package com.apiconcesionarioautos.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class VehicleResponseDTO {

    private String brand;
    private String model;
    private Date manufaturingDate;
    private double numberOfKilometers;
    private int doors;
    private double price;
    private String currency;

    public VehicleResponseDTO() {
    }

    public VehicleResponseDTO(String brand, String model, Date manufaturingDate, double numberOfKilometers, int doors, double price, String currency) {
        this.brand = brand;
        this.model = model;
        this.manufaturingDate = manufaturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
    }
}
