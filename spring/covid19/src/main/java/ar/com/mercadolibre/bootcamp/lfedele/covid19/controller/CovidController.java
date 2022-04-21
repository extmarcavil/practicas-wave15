package ar.com.mercadolibre.bootcamp.lfedele.covid19.controller;

import ar.com.mercadolibre.bootcamp.lfedele.covid19.dto.PersonaDto;
import ar.com.mercadolibre.bootcamp.lfedele.covid19.model.Sintoma;
import ar.com.mercadolibre.bootcamp.lfedele.covid19.service.ICovidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CovidController {
    private final ICovidService covidService;

    public CovidController(ICovidService covidService) {
        this.covidService = covidService;
    }

    @GetMapping("/sintoma")
    public ResponseEntity<List<Sintoma>> findAllSintomas() {
        return new ResponseEntity<>(this.covidService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/sintoma/{name}")
    public ResponseEntity<Sintoma> findByName(@PathVariable String name) {
        return this.covidService
                .findByName(name)
                .map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/risk")
    public ResponseEntity<List<PersonaDto>> findRiskPersons() {
        List<PersonaDto> l = this.covidService
                .findRiskPerson()
                .stream()
                .map(PersonaDto::fromPersona)
                .collect(Collectors.toList());

        return new ResponseEntity<>(l, HttpStatus.OK);
    }
}
