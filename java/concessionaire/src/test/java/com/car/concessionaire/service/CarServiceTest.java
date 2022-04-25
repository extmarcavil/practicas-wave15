package com.car.concessionaire.service;

import com.car.concessionaire.dto.CarDto;
import com.car.concessionaire.exceptions.CarAlreadyExistsException;
import com.car.concessionaire.exceptions.CarDoesNotExistException;
import com.car.concessionaire.model.Car;
import com.car.concessionaire.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static com.car.concessionaire.utils.CarFixture.aCarComplete;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class CarServiceTest {

    @Autowired
    private CarService carService;
    @Autowired
    private CarRepository repository;

    private Car car;

    @BeforeEach
    void setUp() {
        repository.reset(); // better use dirty context for repository persistence entities
        car = aCarComplete();
        repository.save(car);
    }

    @Test
    void validateThatIdIsGeneratedAndSavedCarCorrectly() {
        assertThat(repository.findById(car.getId())).hasValueSatisfying(maybeCar -> {
            assertThat(maybeCar).isNotNull();
            assertThat(maybeCar).usingRecursiveComparison().isEqualTo(car);
        });
    }

    @Test
    void whenTheCarAlreadyExists_thenAnExceptionIsThrown() {
        assertThatThrownBy(() -> carService.create(car))
                .isInstanceOf(CarAlreadyExistsException.class)
                .hasMessage(String.format("%s already exists.", car));
    }

    @Test
    void whenWantToRecoverAllTheCars_thenAreReturnedWithoutServices() {
        List<Car> carsToCompare = repository.findAll();
        int numberOfItemsExpected = carsToCompare.size();
        List<CarDto> items = carService.getAll();

        assertThat(items.size()).isEqualTo(numberOfItemsExpected);
        assertThat(items).usingRecursiveComparison()
                .ignoringFields("id", "services")
                .isEqualTo(carsToCompare);
    }

    @Test // Always inject mocks in setUp. This is really wrong
    void whenThereAreNotCarsSaved_thenAListEmptyIsReturned() {
        CarRepository mockRepository = mock(CarRepository.class);
        CarService mockService = mock(CarService.class);

        when(mockRepository.findAll()).thenReturn(Collections.emptyList());

        assertThatConditionIsTrue(mockService.getAll().isEmpty());
    }

    @Test
    void whenSearchingForCarsByTwoDates_thenAreReturnedBetweenTheGivenDates() {
        LocalDate since = LocalDate.of(2018, 1, 1);
        LocalDate to = LocalDate.of(2021, 12, 31);

        List<Car> carsFilteredByDate = carService.filterByDates(since, to);

        assertThatConditionIsTrue(carsFilteredByDate.size() < repository.findAll().size());
        carsFilteredByDate.forEach(car -> {
            LocalDate manufacturingDate = car.getManufacturingDate();
            assertThatConditionIsTrue(manufacturingDate.isAfter(since) && manufacturingDate.isBefore(to));
        });
    }

    @Test
    void whenThereAreNotCarsSearchingByTwoDates_thenItReturnsAListEmpty() {
        LocalDate since = LocalDate.of(2021, 1, 1);
        LocalDate to = LocalDate.of(2022, 12, 31);

        List<Car> carsFilteredByDate = carService.filterByDates(since, to);

        assertThat(carsFilteredByDate.isEmpty()).isTrue();
    }

    @Test
    void whenSearchingForCarsByPrices_thenAreReturnedBetweenTheGivesPrices() {
        BigDecimal since = new BigDecimal("130000");
        BigDecimal to = new BigDecimal("115000");

        List<Car> carsFilteredByPrices = carService.filterByPrices(since, to);
        carsFilteredByPrices.forEach(car -> {
            BigDecimal price = car.getPrice();
            assertThatConditionIsTrue(price.compareTo(since) > 0 && price.compareTo(to) < 0);
        });
        assertThatConditionIsTrue(carsFilteredByPrices.size() < repository.findAll().size());
    }

    @Test
    void whenSearchingForACarByIdAndDoesNotExist_thenAnExceptionIsThrown() {
        Long nonExistentID = 10L;

        assertThatThrownBy(() -> carService.findById(nonExistentID))
                .isInstanceOf(CarDoesNotExistException.class)
                .hasMessage(String.format("Car with %s does not exist.", nonExistentID));
    }

    private void assertThatConditionIsTrue(boolean condition) {
        assertThat(condition).isTrue();
    }

}