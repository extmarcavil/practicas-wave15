package com.mercadolibre.bootcamp.deportista.service;

import com.mercadolibre.bootcamp.deportista.dto.DeporteDto;
import com.mercadolibre.bootcamp.deportista.dto.PersonaRequestDto;
import com.mercadolibre.bootcamp.deportista.dto.PersonaResponseDto;
import com.mercadolibre.bootcamp.deportista.entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("personaService")
public class PersonaServiceImpl implements ICRUDService<PersonaRequestDto, PersonaResponseDto> {


    /**
     * Injection Of Dependency
     */
    @Autowired
    DeporteServiceImpl sport;

    /**
     * Atributos
     */
    private List<Persona> listPersonas = new ArrayList<>();
    private List<PersonaResponseDto> listPersonaResponse = new ArrayList<>();

    /**
     * Methods.
     *
     * @param obj
     * @return
     */
    @Override
    public PersonaResponseDto save(PersonaRequestDto obj) {
        Persona person = new Persona();
        person.setName(obj.getName());
        person.setSurName(obj.getSurName());
        person.setAge(obj.getAge());

        DeporteDto sportFav = sport.getListDporteDto().stream().filter(d -> d.getSportName().equals(obj.getSportName())).findFirst().get();
        person.setSport(sportFav);

        listPersonas.add(person);

        PersonaResponseDto returnPersonDto = new PersonaResponseDto(person.getName(), person.getSurName(), person.getSport());
        listPersonaResponse.add(returnPersonDto);
        return returnPersonDto;
    }

    @Override
    public List<PersonaResponseDto> findAll() {
        return listPersonaResponse;
    }

    @Override
    public PersonaResponseDto findByName(String name) {
        return null;
    }


}
