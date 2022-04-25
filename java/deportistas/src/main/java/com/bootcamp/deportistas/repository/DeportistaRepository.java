package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.dto.DeporteDTO;
import com.bootcamp.deportistas.dto.PersonaDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeportistaRepository implements IDeportistaRepository{
    List<DeporteDTO> listSports = new ArrayList<>();
    List<PersonaDTO> listPersons = new ArrayList<>();

    public DeportistaRepository() {
        init();
    }

    private void init(){
        listSports.add(new DeporteDTO("Futbol", 1));
        listSports.add(new DeporteDTO("Basketball", 3));
        listSports.add(new DeporteDTO("Baseball", 5));
        listSports.add(new DeporteDTO("Voleyball", 4));
        listSports.add(new DeporteDTO("Atletismo", 2));

        listPersons.add(new PersonaDTO("Juan", "Chaparro", 23,listSports.get(0)));
        listPersons.add(new PersonaDTO("Yury", "Bonilla", 21,listSports.get(1)));
        listPersons.add(new PersonaDTO("Daniel", "Anaya", 24,listSports.get(3)));
    }

    @Override
    public DeporteDTO getSportByName(String sportName){
        return listSports.stream().filter(d -> d.getNombre().equals(sportName)).findFirst().orElse(null);
    }

    @Override
    public List<PersonaDTO> getSportsPersons(){
        return listPersons;
    }

    @Override
    public List<DeporteDTO> getSports(){
        return listSports;
    }
}
