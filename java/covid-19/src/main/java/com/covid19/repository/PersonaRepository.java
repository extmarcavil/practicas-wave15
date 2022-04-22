package com.covid19.repository;

import com.covid19.dto.EnfermoDTO;
import com.covid19.model.Persona;
import com.covid19.model.Sintoma;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonaRepository {

    static List<Persona> listaPersona= new ArrayList<>();
    static {
        List<Sintoma> listaSintoma = new ArrayList<>();
        listaSintoma.add(new Sintoma("0101","Bradicardia",3));
        listaSintoma.add(new Sintoma("0102","fiebre",4));
        List<Sintoma> listaSintoma2 = new ArrayList<>();
        listaSintoma2.add(new Sintoma("0103","dolor",1));
        listaSintoma2.add(new Sintoma("0104","malestar",4));
        listaPersona = new ArrayList<>();
        listaPersona.add(new Persona("1","Silvia","Torres",22,new ArrayList<>()));
        listaPersona.add(new Persona("2","Sofia","Cruz",65,listaSintoma));
        listaPersona.add(new Persona("3","David","Linares",62,listaSintoma2));
    }

    public List<EnfermoDTO> findRiskPerson(){
        List<EnfermoDTO> listaEnferemoDTO = new ArrayList<>();
        List<Persona> listaPersonas;
        listaPersonas = listaPersona.stream()
                .filter(persona -> persona.getEdad()>60 && persona.getListSintomas().size()>0)
                .collect(Collectors.toList());
        for (Persona persona : listaPersonas) {
            EnfermoDTO e = new EnfermoDTO();
            e.setId(persona.getId());
            e.setFullName(persona.getNombre()+" "+persona.getApellido());
            e.setEdad(persona.getEdad());
            e.setListSintomas(persona.getListSintomas());
            //listSickDTO.add(new EnfermoDTO("1", persona.getNombre() +" "+ persona.getApellido(), persona.getEdad(), null));
            listaEnferemoDTO.add(e);
        }
        return listaEnferemoDTO;
    }

}
