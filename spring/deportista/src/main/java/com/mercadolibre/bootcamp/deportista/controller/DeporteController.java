package com.mercadolibre.bootcamp.deportista.controller;

import com.mercadolibre.bootcamp.deportista.dto.DeporteDto;
import com.mercadolibre.bootcamp.deportista.service.ICRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deporte")
public class DeporteController {


    @Autowired
    @Qualifier("deporteService")
    private ICRUDService serviceDeporte;

    /**
     * Metodos
     */
    @PostMapping("/save")
    public DeporteDto guardarDeporte(@RequestBody DeporteDto objDeporte) {
        return (DeporteDto) serviceDeporte.save(objDeporte);
    }

    @GetMapping("/findSports")
    public List<DeporteDto> findAll() {
        return serviceDeporte.findAll();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findByName(@PathVariable String name) {
        DeporteDto sport = (DeporteDto) serviceDeporte.findByName(name);

        return ResponseEntity.ok()
                .body(sport.getSportName() + ", Nivel del deporte: " + sport.getLevel());
    }


}
