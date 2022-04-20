package com.apideportistas.services;

import com.apideportistas.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Locale;

@Service
public class PersonaService implements  IPersonaService {
    //region Variables
    private ArrayList<Persona> listPersonas;
    //endregion

    //region contructor

    public PersonaService() {
        this.listPersonas = new ArrayList<>();
    }

    //endregion

    //region Implementacion

    @Override
    public ArrayList<Persona> obtenerPersonas() {
        return listPersonas;
    }

    @Override
    public Persona buscarPersonaNombre(String nombrePersona) throws Exception {
        if(nombrePersona.isEmpty() || nombrePersona.isBlank())
            throw new Exception("agregue un nombre de deporte valido");

        return  listPersonas.stream().filter(
                        f -> f.Nombre.toLowerCase(Locale.ROOT).equals(nombrePersona.toLowerCase(Locale.ROOT)))
                .findFirst()
                .orElse(null);
    }

    @Override
    public int agregarPersona(Persona persona) {
        int id = 0;
        if(listPersonas.size() <= 0)
            id = 1;
        else
            id =  listPersonas.get(listPersonas.size() - 1).getIdPersona() + 1;

        persona.setIdPersona(id);
        listPersonas.add(persona);
        return  id;
    }

    @Override
    public Persona personabyId(int idPersona) throws Exception {
        if(idPersona <= 0)
            throw new Exception("debe ser mayor a cero (0)");

        return  listPersonas.stream().filter(
                        f -> f.getIdPersona() == idPersona)
                .findFirst()
                .orElse(null);
    }

    //endregion

}
