package com.bootcamp.deportistas.Repository;

import com.bootcamp.deportistas.dtos.PersonaDTO;
import com.bootcamp.deportistas.models.Deporte;
import com.bootcamp.deportistas.models.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonaRepository {
    static List<Persona> listapersona = new ArrayList<>();
    static {
        List<Deporte> listaDeporte = new ArrayList<>();
        listaDeporte.add(new Deporte("futbol", "b"));
        listaDeporte.add(new Deporte("basquetbool", "b"));
        listaDeporte.add(new Deporte("natacion", "b"));

        List<Deporte> listaDeporte2 = new ArrayList<>();
        listaDeporte2.add(new Deporte("patin", "bc"));
        listaDeporte2.add(new Deporte("aerobico", "d"));

        listapersona.add(new Persona("Juan", "Rodriguez",  listaDeporte));
        listapersona.add(new Persona("Ana", "Suearez",  new ArrayList<>()));
        listapersona.add(new Persona("Luis", "Gutierrez",  new ArrayList<>()));
        listapersona.add(new Persona("Maber", "Torres", listaDeporte2));
    }


    public static List<PersonaDTO> buscarPersonasDeportistas(){
        List<PersonaDTO> deportistasDto = new ArrayList<>();
        List<Persona> listaDeportistas = listapersona.stream().filter(p -> p.getListDeportes().size() >= 1).collect(Collectors.toList());

        for (Persona p : listaDeportistas) {
            List<String> deportes = new ArrayList<>();
            for (Deporte d : p.getListDeportes()){
                deportes.add(d.getNombre());
            }
            deportistasDto.add(new PersonaDTO(p.getNombre(), p.getApellido(), deportes));
        }
        return deportistasDto;
    }


}
