package dtoresponseentity.ejerpractico.covid19.repository;

import dtoresponseentity.ejerpractico.covid19.exception.NotFoundException;
import dtoresponseentity.ejerpractico.covid19.model.Persona;
import dtoresponseentity.ejerpractico.covid19.model.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositoryImpl implements IRepository {

    private List<Sintoma> sintomas;
    private List<Persona>  personas;

    public RepositoryImpl() {
        this.sintomas = new ArrayList<>();
        this.personas = new ArrayList<>();
        initData();
    }

    @Override
    public List<Sintoma> findAll() {
        return sintomas;
    }

    @Override
    public Sintoma findByNombre(String nombre) {
        return sintomas.stream()
                .filter(sintoma -> sintoma.getNombre().equals(nombre))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(
                        String.format("No se encontro %s como sintoma ",nombre)
                ));
    }

    @Override
    public List<Persona> findGreaterThan(Integer edad) {
        return personas.stream()
                .filter(persona -> persona.getEdad()>=edad && persona.getSintomas()!=null)
                .collect(Collectors.toList());
    }

    private void initData () {
        Sintoma headache   = new Sintoma("S-01", "headache", "Low");
        Sintoma queasiness = new Sintoma("S-02", "queasiness", "Low");
        Sintoma dizziness  = new Sintoma("S-03", "dizziness", "Low");
        Sintoma fatigue    = new Sintoma("S-04", "fatigue", "Low");
        Sintoma musclePain = new Sintoma("S-05", "musclePain", "Low");

        Persona lenore   = new Persona(1, "Lenore", "Shilvock", 25, List.of(headache));
        Persona wenona   = new Persona(2, "Wenona", "Paddefield", 65, List.of(fatigue,musclePain));
        Persona ade      = new Persona(3, "Ade", "Asple", 75, List.of(dizziness, musclePain));
        Persona nicholle = new Persona(4, "Nicholle", "Abrahamsen", 61, List.of(fatigue, queasiness));

        this.personas.addAll(List.of(lenore, wenona, ade, nicholle));
        this.sintomas.addAll(List.of(headache, queasiness, dizziness, fatigue, musclePain));
    }
}
