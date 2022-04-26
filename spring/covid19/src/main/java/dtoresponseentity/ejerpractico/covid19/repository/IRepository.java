package dtoresponseentity.ejerpractico.covid19.repository;

import dtoresponseentity.ejerpractico.covid19.model.Persona;
import dtoresponseentity.ejerpractico.covid19.model.Sintoma;

import java.util.List;

public interface IRepository {

    List<Sintoma> findAll();
    Sintoma findByNombre(String nombre);
    List<Persona> findGreaterThan(Integer edad);
}
