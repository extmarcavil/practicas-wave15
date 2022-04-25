package com.car.concessionaire.dto;

import com.car.concessionaire.model.Car;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CarDto {

    private final String brand;
    private final String model;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDate manufacturingDate;
    private final String numberOfKilometers;
    private final int doors;
    private final BigDecimal price;
    private final String currency;
    private final int countOfOwners;

    public static CarDto from(Car car) {
        return new CarDto(
                car.getBrand(),
                car.getModel(),
                car.getManufacturingDate(),
                car.getNumberOfKilometers(),
                car.getDoors(),
                car.getPrice(),
                car.getCurrency(),
                car.getCountOfOwners()
        );
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                ", numberOfKilometers='" + numberOfKilometers + '\'' +
                ", doors=" + doors +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", countOfOwners=" + countOfOwners +
                '}';
    }

}
