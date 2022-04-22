package com.apiconcesionarioautos.model;
import java.util.Date;
import java.util.List;

public class Vehicle {
    private int Id;
    public String brand;
    public String model;
    public Date manufaturingDate;
    public double numberOfKilometers;
    public int doors;
    public double price;
    public String currency;
    public List<Service> services;

    //region Constructor


    public Vehicle() {
    }

    public Vehicle(String brand, String model, Date manufaturingDate, double numberOfKilometers,
                   int doors, double price, String currency, List<Service> services) {
        this.brand = brand;
        this.model = model;
        this.manufaturingDate = manufaturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
    }

    //endregion

    //region getters setters

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

    public Date getManufaturingDate() {
        return manufaturingDate;
    }

    public void setManufaturingDate(Date manufaturingDate) {
        this.manufaturingDate = manufaturingDate;
    }

    public double getNumberOfKilometers() {
        return numberOfKilometers;
    }

    public void setNumberOfKilometers(double numberOfKilometers) {
        this.numberOfKilometers = numberOfKilometers;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
//endregion

}
