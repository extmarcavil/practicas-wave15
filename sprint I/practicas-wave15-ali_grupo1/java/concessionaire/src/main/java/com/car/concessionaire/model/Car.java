package com.car.concessionaire.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
public class Car {

    private Long id;

    @NotNull
    private final String brand;
    @NotNull
    private final String model;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDate manufacturingDate;
    @NotNull
    private final String numberOfKilometers;
    @NotNull
    @Positive(message = "The car must have doors")
    private final int doors;
    @NotNull
    @Positive(message = "The price must be greater than 0")
    private final BigDecimal price;
    @NotNull
    private final String currency;
    @NotNull
    private final List<CarServiceEntity> services;
    @NotNull
    @Positive(message = "The car has to have an owner")
    private final int countOfOwners;

    public boolean compareDateOf(LocalDate since, LocalDate to) {
        return this.manufacturingDate.isAfter(since) && this.manufacturingDate.isBefore(to);
    }

    public boolean comparePriceOf(BigDecimal since, BigDecimal to) {
        return this.price.compareTo(since) > 0 && this.price.compareTo(to) < 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return doors == car.doors && countOfOwners == car.countOfOwners
                && Objects.equals(brand, car.brand)
                && Objects.equals(model, car.model)
                && Objects.equals(manufacturingDate, car.manufacturingDate)
                && Objects.equals(numberOfKilometers, car.numberOfKilometers)
                && Objects.equals(price, car.price) && Objects.equals(currency, car.currency)
                && Objects.equals(services, car.services);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, manufacturingDate, numberOfKilometers, doors, price, currency, services, countOfOwners);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                ", numberOfKilometers='" + numberOfKilometers + '\'' +
                ", doors=" + doors +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", services=" + services +
                ", countOfOwners=" + countOfOwners +
                '}';
    }
}
