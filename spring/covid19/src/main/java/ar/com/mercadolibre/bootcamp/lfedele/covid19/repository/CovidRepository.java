package ar.com.mercadolibre.bootcamp.lfedele.covid19.repository;

import ar.com.mercadolibre.bootcamp.lfedele.covid19.model.Persona;
import ar.com.mercadolibre.bootcamp.lfedele.covid19.model.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CovidRepository implements ICovidRepository {

    private final List<Sintoma> sintomas = new ArrayList<>();
    private final List<Persona> personas = new ArrayList<>();

    public CovidRepository() {
        Sintoma s1 = new Sintoma("S1", "Tos", 2);
        Sintoma s2 = new Sintoma("S2", "Dolor de garganta", 3);
        Sintoma s3 = new Sintoma("S3", "Dolor de cabeza", 2);

        this.sintomas.add(s1);
        this.sintomas.add(s2);
        this.sintomas.add(s3);

        Persona p1 = new Persona("Cosme", "Fulanito", 50);
        p1.addSintoma(s3);
        Persona p2 = new Persona("Homero", "Thompson", 50);
        Persona p3 = new Persona("Max", "Power", 70);
        p3.addSintoma(s1);
        p3.addSintoma(s2);

        this.personas.add(p1);
        this.personas.add(p2);
        this.personas.add(p3);
    }

    @Override
    public List<Sintoma> findAll() {
        return this.sintomas;
    }

    @Override
    public List<Persona> personas() {
        return this.personas;
    }
}
