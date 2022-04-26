package com.bootcamp.covid.controller;

import com.bootcamp.covid.modelo.Persona;
import com.bootcamp.covid.modelo.Sintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CovidController {

    private static List<Persona> listaPersonas = new ArrayList<>();
    private static List<Sintoma> listaSintomas = new ArrayList<>();

    public CovidController() {
        inicializarValores();
    }

    @GetMapping("/findSymptom")
    public String verTodosLosSintomas(){
        return "";
    }

    public List<Sintoma> getSintomas(){
        return listaSintomas;
    }

    public static void inicializarValores(){
        Persona persona1 = new Persona(1,"Juan","Perez",62);
        Persona persona2 = new Persona(2,"Pedro","Perez",33);
        Persona persona3 = new Persona(3,"Tito","Perez",24);
        Persona persona4 = new Persona(4,"Julian","Perez",78);
        Persona persona5 = new Persona(5,"Pablo","Perez",21);

        listaPersonas.addAll(List.of(persona1,persona2,persona3,persona4,persona5));

        Sintoma sintoma1 = new Sintoma("A","Dolor muscular",0);
        Sintoma sintoma2 = new Sintoma("B","Dolor de cabeza",3);
        Sintoma sintoma3 = new Sintoma("C","Fiebre",4);
        Sintoma sintoma4 = new Sintoma("D","Falta de aire",5);
        Sintoma sintoma5 = new Sintoma("E","Perdida olfato",1);

        listaSintomas.addAll(List.of(sintoma1,sintoma2,sintoma3,sintoma4,sintoma5));

    }
}
