package com.vparula.concesionaria.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Auto {
    private String brand;
    private String model;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date manufacturingDate;
    private String numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private Integer countOfOwners;
    private List<Servicio> services;

    public Auto() {
    }

    public Auto(String brand, String model, Date manufacturingDate, String numberOfKilometers, Integer doors, Double price, String currency, Integer countOfOwners, List<Servicio> services) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;
        this.services = services;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getNumberOfKilometers() {
        return numberOfKilometers;
    }

    public void setNumberOfKilometers(String numberOfKilometers) {
        this.numberOfKilometers = numberOfKilometers;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getCountOfOwners() {
        return countOfOwners;
    }

    public void setCountOfOwners(Integer countOfOwners) {
        this.countOfOwners = countOfOwners;
    }

    public List<Servicio> getServices() {
        return services;
    }

    public void setServices(List<Servicio> services) {
        this.services = services;
    }
}
