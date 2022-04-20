package com.apideportistas.services;

import com.apideportistas.dto.NuevaInscripcionDTO;
import com.apideportistas.dto.PersonaDeporteDTO;
import com.apideportistas.model.InscripcionPersonaDeporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class InscripcionService implements  IInscripcionService {

    //region Variables
    private ArrayList<InscripcionPersonaDeporte> listInscripcionPersonaDeporte;
    @Autowired
    private IPersonaService _personaService;
    @Autowired
    private IDeporteService _deporteService;
    //endregion

    //region Constructor Publico

    public InscripcionService() {
        listInscripcionPersonaDeporte = new ArrayList<>();
    }

    //endregion

    //region Implementacion

    @Override
    public boolean inscribirPersonaDeporte(NuevaInscripcionDTO nuevainsc) throws Exception {
        var existe = listInscripcionPersonaDeporte.stream().filter(f -> f.IdPersona == nuevainsc.IdPersona &&
                f.IdDeporte == nuevainsc.IdDeporte);
        if(existe.count() > 0)
            throw  new Exception("ya esta inscrito la persona al deporte seleccionado");
        else{
            var nuevaInscripcion = new InscripcionPersonaDeporte();
            nuevaInscripcion.IdDeporte = nuevainsc.IdDeporte;
            nuevaInscripcion.IdPersona = nuevainsc.IdPersona;
            listInscripcionPersonaDeporte.add(nuevaInscripcion);
        }
        return true;
    }

    @Override
    public ArrayList<PersonaDeporteDTO> obtenerPersonasDeportes() {
        var listResult = new ArrayList<PersonaDeporteDTO>();
        if(listInscripcionPersonaDeporte.size() > 0){
            listInscripcionPersonaDeporte.forEach(item -> {
                try {
                    var persona = _personaService.personabyId(item.IdPersona);
                    var deporteInfo = _deporteService.deportebyId(item.IdDeporte);
                    var dto = new  PersonaDeporteDTO();
                    dto.setDeporte(deporteInfo.Nombre);
                    dto.setNombreDeportista(persona.Nombre + " " + persona.Apellido);
                    listResult.add(dto);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        return listResult;
    }

    //endregion
}
