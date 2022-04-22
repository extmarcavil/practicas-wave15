package com.covid.covid.servicio;

import com.covid.covid.dto.*;
import com.covid.covid.repositorio.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SintomaServicio implements ISintomaServicio{
    IRepositorioSintoma repositorio;

    public SintomaServicio(IRepositorioSintoma repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public ArrayList<SintomaDTO> getListaSintoma() {
        return repositorio.getTodosLosSintomas();
    }

    @Override
    public SintomaDTO obtenerSintoma(String nombre) {
        SintomaDTO sintoma = null;
        try {
            for(SintomaDTO sintomadto : repositorio.getTodosLosSintomas()){
                if (sintomadto.getNombre().equals(nombre)){
                   sintoma = sintomadto;
                   break;
                }
            }
        }catch(RuntimeException e){
            return new SintomaDTO("ERROR", e.getMessage(), "NONE");
        }
        return sintoma;
    }

    @Override
    public ArrayList<PacienteDTO> obtenerPacientes() {
        ArrayList<PacienteDTO> pacientes = new ArrayList<PacienteDTO>();

        for(PersonaDTO persona : repositorio.getTodasLasPersonas()) {
            if (persona.tieneSintomas() && persona.personaAdulta()){
                pacientes.add(new PacienteDTO(persona.getNombre(), persona.getApellido(),persona.getListaSintomas()));
            }
        }

        return pacientes;
    }
}
