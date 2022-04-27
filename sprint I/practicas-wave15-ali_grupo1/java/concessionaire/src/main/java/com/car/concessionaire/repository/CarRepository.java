package com.car.concessionaire.repository;

import com.car.concessionaire.model.Car;
import com.car.concessionaire.model.CarServiceEntity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.toIntExact;

@Repository
public class CarRepository extends AbstractRepository<Car, Long> {

    private final List<CarServiceEntity> carServiceEntities = List.of(
            new CarServiceEntity(LocalDate.of(2003, 5, 20), "6000", "Change air filters")
    );

    @Override
    protected List<Car> initData() {
        return Stream.of(
                new Car(1L,"Chevrolet", "Corsa", LocalDate.of(2000, 11, 20),
                        "115000", 4, new BigDecimal("90000"), "AR",
                        carServiceEntities, 3),
                new Car(2L,"Peugeot", "208", LocalDate.of(2004, 5, 20),
                        "10000", 5, new BigDecimal("150000"), "AR",
                        carServiceEntities, 2),
                new Car(3L,"Renault", "Clio", LocalDate.of(2019, 1, 10),
                        "90004", 4, new BigDecimal("133444"), "AR",
                        carServiceEntities, 2),
                new Car(4L,"Volkswagen", "Golf", LocalDate.of(2020, 6, 3),
                        "5000", 5, new BigDecimal("455000"), "AR",
                        carServiceEntities, 1)
        ).collect(Collectors.toList());
    }

    protected void generateId(Car car) {
        car.setId((long)(repository.size()+1));
    }

    @Override
    public Car save(Car car) {
        generateId(car);
        repository.add(car);
        return repository.get(toIntExact(car.getId())-1);
    }

    @Override
    public void update(Car car) {

    }

    @Override
    public List<Car> findAll() {
        return repository;
    }

    @Override
    public Optional<Car> findById(Long id) {
        return repository.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean exists(Car car) {
        return repository.contains(car);
    }
}
