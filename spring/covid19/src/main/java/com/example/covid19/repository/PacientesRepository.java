package com.example.covid19.repository;

import com.example.covid19.DTO.PacienteDTO;
import com.example.covid19.entities.Persona;
import com.example.covid19.entities.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PacientesRepository implements IPacientesRepository {

    private final List<Persona> pacientes = new ArrayList<>();
    private final List<Sintoma> sintomas = new ArrayList<>();

    public PacientesRepository() {
        initData();
    }

    private void initData() {
        Sintoma fiebre = new Sintoma(1,"Fiebre",3);
        Sintoma tos = new Sintoma(2,"Tos",1);
        Sintoma dolorGarganta = new Sintoma(3,"Dolor de garganta",2);
        Sintoma dolorCabeza = new Sintoma(4,"Dolor de cabeza",3);
        Sintoma dolorEstomago = new Sintoma(5,"Dolor de estomago",4);
        Sintoma dolorPecho = new Sintoma(6,"Dolor de pecho",5);
        Sintoma dificultadRespirar = new Sintoma(7,"Dificultad para Respirar",5);

        Persona persona1 = new Persona(1,"Juan","Perez",61, List.of(fiebre,tos));
        Persona persona2 = new Persona(2,"Pedro","Perez",40, List.of(dolorGarganta,dolorEstomago));
        Persona persona3 = new Persona(3,"Maria","Perez",75, List.of(dificultadRespirar));
        Persona persona4 = new Persona(4,"Juan","Perez",80, new ArrayList<>());

        this.pacientes.addAll(Arrays.asList(persona1,persona2,persona3,persona4));
        this.sintomas.addAll(Arrays.asList(fiebre,tos,dolorGarganta,dolorCabeza,dolorEstomago,dolorPecho,dificultadRespirar));
    }

    @Override
    public List<Sintoma> GetAllSintomas(){
        return sintomas;
    }

    @Override
    public Optional<Sintoma> getSintomaPorNombre(String nombre){
        return sintomas.stream()
                .filter(sintoma -> sintoma.getNombre().equals(nombre))
                .findFirst();
    }

    @Override
    public List<PacienteDTO> getPersonas(){

        List<PacienteDTO> listadoPacientesRiesgo = new ArrayList<>();

        List<Persona> listadoPersonas = pacientes.stream()
                .filter(p -> p.getEdad() > 60 && p.getListaSintomas().size() > 0)
                .collect(Collectors.toList());

        for(Persona p : listadoPersonas){
            List <String> sintomas = new ArrayList<>();
            for(Sintoma s : p.getListaSintomas()){
                sintomas.add(s.getNombre());
            }
            listadoPacientesRiesgo.add(new PacienteDTO(p.getId(), p.getNombre() + " " + p.getApellido(),  p.getEdad(), sintomas));
        }
        return listadoPacientesRiesgo;
    }
}
