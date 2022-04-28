package com.company;

public class Vehicle {
    private String model;
    private String brand;
    private Float price;

    public Vehicle(String model, String brand, float price) {
        this.model = model;
        this.brand = brand;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + model + '\'' +
                ", marca='" + brand + '\'' +
                ", precio=" + price +
                '}';
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
