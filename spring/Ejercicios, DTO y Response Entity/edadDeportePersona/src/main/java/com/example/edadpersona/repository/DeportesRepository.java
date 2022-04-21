package com.example.edadpersona.repository;

import com.example.edadpersona.model.Deporte;

import java.util.ArrayList;
import java.util.List;

public class DeportesRepository {

    static List<Deporte> deportes = new ArrayList<>();
    static{
        deportes.add(new Deporte("Futbol","Facil"));
        deportes.add(new Deporte("Natacion","Medio"));
        deportes.add(new Deporte("Boxeo","Dificil"));
        deportes.add(new Deporte("Rugby","Dificil"));
    }

    public static List<Deporte> getDeportes(){
        return deportes;
    }

    public static Deporte getDeporteByName(String name){
        return deportes.stream().filter(d -> d.getNombre().equals(name)).findFirst().orElse(null);
    }
}
