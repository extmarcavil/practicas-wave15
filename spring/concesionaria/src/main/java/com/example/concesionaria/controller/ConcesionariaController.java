package com.example.concesionaria.controller;

import com.example.concesionaria.dto.CarDTO;
import com.example.concesionaria.dto.CarWithoutServicesDTO;
import com.example.concesionaria.model.Car;
import com.example.concesionaria.service.IVehiculoService;
import org.apache.tomcat.jni.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class ConcesionariaController {

    private IVehiculoService vehiculoService;

    public ConcesionariaController(IVehiculoService vehiculoService){
        this.vehiculoService = vehiculoService;
    }

    @PostMapping
    ResponseEntity<CarDTO> crear(@RequestBody Car newCar){
        return ResponseEntity.ok(vehiculoService.crear(newCar));
    }

    @GetMapping
    ResponseEntity<List<CarWithoutServicesDTO>> findAllWithoutServices(){
        return ResponseEntity.ok(vehiculoService.findAll());
    }

    @GetMapping("/dates")
    ResponseEntity<List<CarWithoutServicesDTO>> findAllBetweenAndBydate(@RequestParam(required = false, defaultValue = "-1") String since,
                                                                        @RequestParam(required = false, defaultValue = "-1") String to){
        LocalDate desde, hasta;
        if(since.equals("-1")){
            desde = LocalDate.MIN;
        } else {
            desde = LocalDate.parse(since);
        }
        if(to.equals("-1")){
            hasta = LocalDate.now();
        } else {
            hasta = LocalDate.parse(to);
        }
        return ResponseEntity.ok(vehiculoService.findBetweenAndOrderedByDate(desde, hasta));
    }

    @GetMapping("/prices")
    ResponseEntity<List<CarWithoutServicesDTO>> findAllBetweenAndByPrice(@RequestParam(required = false, defaultValue = "-1") String since,
                                                                        @RequestParam(required = false, defaultValue = "-1") String to){
        LocalDate desde, hasta;
        if(since.equals("-1")){
            desde = LocalDate.MIN;
        } else {
            desde = LocalDate.parse(since);
        }
        if(to.equals("-1")){
            hasta = LocalDate.now();
        } else {
            hasta = LocalDate.parse(to);
        }
        return ResponseEntity.ok(vehiculoService.findBetweenAndOrderedByPrice(desde, hasta));
    }

    @GetMapping("/{id}")
    ResponseEntity<CarDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(vehiculoService.findById(id));
    }


}
