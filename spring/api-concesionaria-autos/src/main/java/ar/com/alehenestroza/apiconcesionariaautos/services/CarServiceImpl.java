package ar.com.alehenestroza.apiconcesionariaautos.services;

import ar.com.alehenestroza.apiconcesionariaautos.dto.CarDTO;
import ar.com.alehenestroza.apiconcesionariaautos.models.Car;
import ar.com.alehenestroza.apiconcesionariaautos.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public Car save(CarDTO carDTO) {
        return this.carRepository.save(carDTO);
    }

    @Override
    public List<Car> getAll() {
        return this.carRepository.getAll();
    }

    @Override
    public List<Car> getCarsBetweenDates(LocalDate since, LocalDate to) {
        return this.carRepository.getCarsBetweenDates(since, to);
    }

    @Override
    public List<Car> getCarsBetweenPrices(Double since, Double to) {
        return this.carRepository.getCarsBetweenPrices(since, to);
    }

    @Override
    public Car getById(Integer id) {
        return this.carRepository.getById(id);
    }
}
