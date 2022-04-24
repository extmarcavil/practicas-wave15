package ar.com.mercadolibre.bootcamp.lfedele.concecionaria.controller;

import ar.com.mercadolibre.bootcamp.lfedele.concecionaria.dto.VehicleDto;
import ar.com.mercadolibre.bootcamp.lfedele.concecionaria.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<VehicleDto>> findAll() {
        return new ResponseEntity<>(vehicleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> findById(@PathVariable Long id) {
        return vehicleService
                .findById(id)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDto>> findByPrice(@RequestParam Integer since, @RequestParam Integer to) {
        return new ResponseEntity<>(vehicleService.findByPrice(since, to), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VehicleDto> save(@RequestBody VehicleDto vehicleDto) {
        return new ResponseEntity<>(vehicleService.save(vehicleDto), HttpStatus.OK);
    }
}
