package com.apicovid19.services;
import com.apicovid19.dtos.PersonaDTO;
import com.apicovid19.models.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonaService implements IPersonaService  {

    //region Variables
    private  ArrayList<Persona> listPersonas;
    //endregion

    //region constructor

    public PersonaService() {
        listPersonas = new ArrayList<>();
    }

    //endregion

    //region Implementacion
    @Override
    public int agregarPersona(PersonaDTO persona) {
        var personaModel = new Persona();
        personaModel.setApellido(persona.getApellido());
        personaModel.setNombre(persona.getNombre());
        personaModel.setEdad(persona.getEdad());
        personaModel.setId(nuevoIdPersona());
        listPersonas.add(personaModel);
        return personaModel.getId();
    }

    @Override
    public ArrayList<PersonaDTO> buscarPersonas()
    {
        var listResult = new ArrayList<PersonaDTO>();
        listPersonas.forEach(item -> {
            var dto = new  PersonaDTO();
            dto.setNombre(item.getNombre());
            dto.setApellido(item.getApellido());
            dto.setEdad(item.getEdad());
            dto.setId(item.getId());
            listResult.add(dto);
        });
        return listResult;
    }

    @Override
    public PersonaDTO personaID(int IdPersona) {
        return buscarPersonas().stream().filter(f ->
                f.getId() == IdPersona).findFirst().orElse(null);
    }

    //endregion

    //region Privados
    private  int nuevoIdPersona()
    {
        var idNuevaPersona = 0;
        if(listPersonas.size() <= 0)
            idNuevaPersona = 1;
        else
            idNuevaPersona = listPersonas.get(listPersonas.size() - 1).getId() + 1;

        return  idNuevaPersona;
    }
    //endregion
}
