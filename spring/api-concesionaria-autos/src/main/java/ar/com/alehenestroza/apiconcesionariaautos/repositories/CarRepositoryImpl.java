package ar.com.alehenestroza.apiconcesionariaautos.repositories;

import ar.com.alehenestroza.apiconcesionariaautos.dto.CarDTO;
import ar.com.alehenestroza.apiconcesionariaautos.models.Car;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarRepositoryImpl implements CarRepository {
    private final List<Car> cars;
    private Integer nextId;

    public CarRepositoryImpl() {
        cars = new ArrayList<>();
        nextId = 1;
    }

    @Override
    public Car save(CarDTO carDTO) {
        Car car = new Car(carDTO, nextId);
        nextId++;
        cars.add(car);
        return car;
    }

    @Override
    public List<Car> getAll() {
        return cars;
    }

    @Override
    public List<Car> getCarsBetweenDates(LocalDate since, LocalDate to) {
        return cars.stream()
                .filter(p -> p.getManufacturingDate().isAfter(since) && p.getManufacturingDate().isBefore(to))
                .sorted(Comparator.comparing(Car::getManufacturingDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsBetweenPrices(Double since, Double to) {
        return cars.stream()
                .filter(p -> p.getPrice() >= since && p.getPrice() <= to)
                .sorted(Comparator.comparing(Car::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public Car getById(Integer id) {
        return cars.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
