package com.car.concessionaire.utils;

import com.car.concessionaire.model.Car;
import com.car.concessionaire.model.CarServiceEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CarFixture {

    public static CarServiceEntity aCarServiceEntity() {
        return new CarServiceEntity(LocalDate.of(2003, 5, 20),
                "6000",
                "Change air filters");
    }

    public static Car aCarComplete() {
        Car car = new Car(6L,"Chevrolet", "Agile", LocalDate.of(2020, 5, 20),
                        "2222", 4, new BigDecimal("98000"), "AR",
                        List.of(aCarServiceEntity()), 1);
        car.setId(null);
        return car;
    }

    public static Car otherCarComplete() {
        return new Car(20L,"Chevrolet", "Agile 2", LocalDate.of(2022, 5, 20),
                "3323", 4, new BigDecimal("100000"), "AR",
                List.of(aCarServiceEntity()), 1);
    }

    public static Car carWithLessThanOneDoor() {
        return new Car(7L,"Peugeot", "208", LocalDate.of(2020, 5, 20),
                "10000", -1, new BigDecimal("150000"), "AR",
                List.of(aCarServiceEntity()), 2);
    }

    public static Car carPriceLessThanOne() {
        return new Car(7L,"Peugeot", "208", LocalDate.of(2020, 5, 20),
                "10000", 2, BigDecimal.ZERO, "AR",
                List.of(aCarServiceEntity()), 2);
    }

    public static Car carWithoutAnOwner() {
        return new Car(7L,"Peugeot", "208", LocalDate.of(2020, 5, 20),
                "10000", 2, new BigDecimal("150000"), "AR",
                List.of(aCarServiceEntity()), 0);
    }

    public static Car carWithFieldsNull() {
        return new Car(7L,null, null, LocalDate.of(2020, 5, 20),
                null, 0, null, null,
                null, 0);
    }

    public static Car createCarWithPrice(BigDecimal price) {
        return new Car(6L,"Chevrolet", "Agile", LocalDate.of(2020, 5, 20),
                "2222", 4, price, "AR",
                List.of(aCarServiceEntity()), 1);
    }

    public static Car createCarWithManufacturingDate(LocalDate manufacturingDate) {
        return new Car(6L,"Chevrolet", "Agile", manufacturingDate,
                "2222", 4, new BigDecimal("150000"), "AR",
                List.of(aCarServiceEntity()), 1);
    }
}
