package com.apideportistas.services;

import com.apideportistas.dto.NuevaInscripcionDTO;
import com.apideportistas.dto.PersonaDeporteDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface IInscripcionService {
    boolean inscribirPersonaDeporte(NuevaInscripcionDTO nuevainsc) throws  Exception;

    ArrayList<PersonaDeporteDTO> obtenerPersonasDeportes();
}
