package ar.com.alehenestroza.apiconcesionariaautos.dto;

import ar.com.alehenestroza.apiconcesionariaautos.models.CarMechanicalService;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarDTO {
    private String              brand;
    private String              model;
    private String              currency;
    private String              manufacturingDate;
    private Integer             numberOfKilometers;
    private Integer             doors;
    private Integer             countOfOwners;
    private Double              price;
    private List<CarMechanicalService>    services;

    @Override
    public String toString() {
        return "CarDTO{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", currency='" + currency + '\'' +
                ", manufacturingDate='" + manufacturingDate + '\'' +
                ", numberOfKilometers=" + numberOfKilometers +
                ", doors=" + doors +
                ", countOfOwners=" + countOfOwners +
                ", price=" + price +
                ", services=" + services +
                '}';
    }
}
