package com.example.demo.repository;

import com.example.demo.model.Deporte;
import com.example.demo.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeportistasRepository implements IDeportistasRepository{

    List<Deporte> deportes;
    List<Persona> personas;

    public DeportistasRepository(){
        this.deportes = new ArrayList<>();
        this.personas = new ArrayList<>();
        init();
    }

    private void init() {

        Deporte d1 = new Deporte("Futbol",2);
        deportes.add(d1);
        Persona p1 = new Persona("Maria","Lopez",23,d1 );
        personas.add(p1);

        Deporte d2 = new Deporte("Tenis",3);
        Persona p2 = new Persona("Juan","Perez",60,d2);
        deportes.add(d2);
        personas.add(p2);
        Persona p3 = new Persona("Juan","Lopez",12,d1);
        personas.add(p3);

        Deporte d3 = new Deporte("Basket",2);
        deportes.add(d3);
        Persona p4 = new Persona("Silvia","Lopez",23,d3 );
        personas.add(p4);
    }

    @Override
    public List<Deporte> getSports() {
        return deportes;
    }

    @Override
    public int getLevel(String name) {
        Deporte d1 = deportes.stream().filter(d -> d.getNombre().equals(name)).findFirst().orElse(null);
        System.out.println(d1.getNivel());
        if(d1 == null){return -1;}
        return d1.getNivel();
    }

    @Override
    public List<Persona> getPersons() {
        return personas;
    }

}
