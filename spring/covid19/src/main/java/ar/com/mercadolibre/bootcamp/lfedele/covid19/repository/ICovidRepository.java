package ar.com.mercadolibre.bootcamp.lfedele.covid19.repository;

import ar.com.mercadolibre.bootcamp.lfedele.covid19.model.Persona;
import ar.com.mercadolibre.bootcamp.lfedele.covid19.model.Sintoma;

import java.util.List;

public interface ICovidRepository {
    List<Sintoma> findAll();
    List<Persona> personas();
}
