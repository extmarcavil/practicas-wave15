package ar.com.alehenestroza.apiconcesionariaautos.repositories;

import ar.com.alehenestroza.apiconcesionariaautos.dto.CarDTO;
import ar.com.alehenestroza.apiconcesionariaautos.models.Car;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository {
    Car save(CarDTO carDTO);
    List<Car> getAll();
    List<Car> getCarsBetweenDates(LocalDate since, LocalDate to);
    List<Car> getCarsBetweenPrices(Double since, Double to);
    Car getById(Integer id);
}
