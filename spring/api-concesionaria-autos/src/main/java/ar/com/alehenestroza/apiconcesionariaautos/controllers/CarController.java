package ar.com.alehenestroza.apiconcesionariaautos.controllers;

import ar.com.alehenestroza.apiconcesionariaautos.dto.CarDTO;
import ar.com.alehenestroza.apiconcesionariaautos.models.Car;
import ar.com.alehenestroza.apiconcesionariaautos.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/vehicles")
public class CarController {
    private final CarService carService;

    @PostMapping()
    public ResponseEntity<Car> save(@RequestBody CarDTO carDTO) {
        return ResponseEntity.ok(this.carService.save(carDTO));
    }

    @GetMapping()
    public ResponseEntity<List<Car>> getAll() {
        return ResponseEntity.ok(this.carService.getAll());
    }

    @GetMapping("/dates")
    public List<Car> getByDate(@RequestParam String since, @RequestParam String to) {
        LocalDate sinceDate = LocalDate.parse(since, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate toDate    = LocalDate.parse(to, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return this.carService.getCarsBetweenDates(sinceDate, toDate);
    }

    @GetMapping("/price")
    public List<Car> getByPrice(@RequestParam Double since, @RequestParam Double to) {
        return this.carService.getCarsBetweenPrices(since, to);
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable Integer id) {
        return this.carService.getById(id);
    }
}
