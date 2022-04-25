package com.vparula.concesionaria.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class AutoDTO {
    private String brand;
    private String model;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date manufacturingDate;
    private String numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private Integer countOfOwners;

    public AutoDTO() {
    }

    public AutoDTO(String brand, String model, Date manufacturingDate, String numberOfKilometers, Integer doors, Double price, String currency, Integer countOfOwners) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;
    }
}

