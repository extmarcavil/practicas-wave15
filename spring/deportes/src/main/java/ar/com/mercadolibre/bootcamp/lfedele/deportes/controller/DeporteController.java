package ar.com.mercadolibre.bootcamp.lfedele.deportes.controller;

import ar.com.mercadolibre.bootcamp.lfedele.deportes.model.Deporte;
import ar.com.mercadolibre.bootcamp.lfedele.deportes.service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {
    @Autowired
    private DeporteService deporteService;

    @GetMapping("/findSport")
    public List<Deporte> findSport() {
        return this.deporteService.findAllSports();
    }

    @GetMapping("findSport/{name}")
    public ResponseEntity<Deporte> findSportByName(@PathVariable String name) {
        return this.deporteService.findSportByName(name)
                .map(deporte -> new ResponseEntity<>(deporte, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
