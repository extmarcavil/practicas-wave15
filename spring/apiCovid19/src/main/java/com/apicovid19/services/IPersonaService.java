package com.apicovid19.services;
import com.apicovid19.dtos.PersonaDTO;
import java.util.ArrayList;

public interface IPersonaService {

    int agregarPersona(PersonaDTO persona);

    ArrayList<PersonaDTO> buscarPersonas();

    PersonaDTO personaID(int IdPersona);
}
