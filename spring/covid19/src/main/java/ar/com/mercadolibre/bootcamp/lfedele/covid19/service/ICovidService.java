package ar.com.mercadolibre.bootcamp.lfedele.covid19.service;

import ar.com.mercadolibre.bootcamp.lfedele.covid19.model.Persona;
import ar.com.mercadolibre.bootcamp.lfedele.covid19.model.Sintoma;

import java.util.List;
import java.util.Optional;

public interface ICovidService {
    List<Sintoma> findAll();
    Optional<Sintoma> findByName(String name);
    List<Persona> findRiskPerson();
}
