package com.springvivo.deportistas.service;

import com.springvivo.deportistas.dto.PersonaDTO;
import com.springvivo.deportistas.entity.Deporte;
import com.springvivo.deportistas.entity.Persona;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeporteServiceImpl implements DeporteService {

    private List<Deporte> deportes = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();


    public DeporteServiceImpl() {
        this.deportes = getSportRepository();
        this.personas = getPeopleRepository();
    }

    @Override
    public List<Deporte> getAllSports() {
        return this.deportes;
    }

    @Override
    public String findSport(String nombre) {
        Deporte deporte = deportes.stream().filter(d -> d.getNombre().equals(nombre))
                .findAny().orElse(null);
        return deporte.getNivel();
    }

    @Override
    public List<PersonaDTO> getSportPeople(){
        List<PersonaDTO> sportPeople = personas.stream()
                .map(p -> new PersonaDTO(p.getNombre(), p.getApellido(),new String[]{p.getDeportes().get(0).getNombre(),p.getDeportes().get(1).getNombre()}))
                .collect(Collectors.toList());

        return sportPeople;
    }

    private List<Deporte> getSportRepository(){
        this.deportes.add(new Deporte("Basketball","Principiante"));
        this.deportes.add(new Deporte("Tenis","Intermedio"));
        this.deportes.add(new Deporte("Arqueria","Avanzado"));
        this.deportes.add(new Deporte("Karate","Principiante"));
        this.deportes.add(new Deporte("Boxeo","Intermedio"));

        System.out.println("Tamanio en service");
        System.out.println(this.deportes.size());
        return this.deportes;
    }

    private List<Persona> getPeopleRepository(){
        this.personas.add(new Persona("Juan","Perez",32, Arrays.asList(deportes.get(0), deportes.get(2))));
        this.personas.add(new Persona("Lucia","Ruiz",25, Arrays.asList(deportes.get(1), deportes.get(3))));
        this.personas.add(new Persona("Martin","Paz",40, Arrays.asList(deportes.get(3), deportes.get(4))));
        this.personas.add(new Persona("Maria","Villar",29, Arrays.asList(deportes.get(2), deportes.get(3))));

        return this.personas;
    }



}
