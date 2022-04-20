package com.practicas.deportistas.servicios;

import com.practicas.deportistas.dto.Deporte;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ServicioDeportes {
    public static List<Deporte> buscarTodos(){
        List<Deporte> deportes = new ArrayList<Deporte>();
        deportes = new ArrayList<Deporte>();
        deportes.add(new Deporte("Fútbol",2));
        deportes.add(new Deporte("Taekwondo",6));
        deportes.add(new Deporte("Box",3));
        deportes.add(new Deporte("Béisbol",5));
        deportes.add(new Deporte("Lucha Libre",3));
        return deportes;
    }

    public static String buscarDeporte(String name){
        List<Deporte> lista = buscarTodos();
        String response = "";
        try {
            int nivel = lista.stream()
                    .filter(deporte -> deporte.getNombre().equals(name))
                    .findFirst()
                    .get()
                    .getNivel();
            response = "nivel: "+nivel;
        }catch (NoSuchElementException e){
            response = "El deporte ("+name+") no se encuentra registrado.";
        }
        return response;
    }
}
