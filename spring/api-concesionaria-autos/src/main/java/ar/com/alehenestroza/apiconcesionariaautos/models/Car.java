package ar.com.alehenestroza.apiconcesionariaautos.models;

import ar.com.alehenestroza.apiconcesionariaautos.dto.CarDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
public class Car {
    private Integer             id;
    private String              brand;
    private String              model;
    private String              currency;
    private LocalDate           manufacturingDate;
    private Integer             numberOfKilometers;
    private Integer             doors;
    private Integer             countOfOwners;
    private Double              price;
    private List<CarMechanicalService>    services;

    public Car(CarDTO car, Integer id) {
        this.id             = id;
        brand               = car.getBrand();
        model               = car.getModel();
        currency            = car.getCurrency();
        manufacturingDate   = LocalDate.parse(car.getManufacturingDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        numberOfKilometers  = car.getNumberOfKilometers();
        doors               = car.getDoors();
        countOfOwners       = car.getCountOfOwners();
        price               = car.getPrice();
        services            = car.getServices();
    }
}
