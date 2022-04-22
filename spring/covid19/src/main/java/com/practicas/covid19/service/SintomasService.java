package com.practicas.covid19.service;

import com.practicas.covid19.dto.SintomaDTO;
import com.practicas.covid19.model.Sintoma;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class SintomasService {
    public static List<SintomaDTO> obtenerSintomasDTO(){
        return obtenerSintomas().stream().map(sintoma -> new SintomaDTO(sintoma.getNombre())).collect(Collectors.toList());
    }

    public static List<Sintoma> obtenerSintomas(){
        List<Sintoma> sintomas = new ArrayList<Sintoma>();
        sintomas.add(new Sintoma("0001", "Fiebre", 4));
        sintomas.add(new Sintoma("0002", "Tos", 1));
        sintomas.add(new Sintoma("0003", "Cansancio", 2));
        sintomas.add(new Sintoma("0004", "Pérdida del Gusto", 2));
        sintomas.add(new Sintoma("0005", "Pérdida del Olfato", 2));
        sintomas.add(new Sintoma("0006 ", "Dolor de Cabeza", 3));
        sintomas.add(new Sintoma("0007", "Dolor de Garganta", 2));
        sintomas.add(new Sintoma("0008", "Ojos rojos", 2));
        return sintomas;
    }

    public static String buscarSintoma(String name){
        List<Sintoma> lista = obtenerSintomas();
        String response = "";
        try {
            int nivel = lista.stream()
                    .filter(sintoma -> sintoma.getNombre().equals(name))
                    .findFirst()
                    .get()
                    .getNivelDeGravedad();
            response = "Nivel de gravedad: "+nivel;
        }catch (NoSuchElementException e){
            response = "El sìntoma ("+name+") no se encuentra registrado.";
        }
        return response;
    }
}
