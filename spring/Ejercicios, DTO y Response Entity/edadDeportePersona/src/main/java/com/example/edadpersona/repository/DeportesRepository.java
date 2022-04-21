package com.example.edadpersona.repository;

import com.example.edadpersona.dtos.DeporteDTO;
import com.example.edadpersona.model.Deporte;

import java.util.ArrayList;
import java.util.List;

public class DeportesRepository {

    static List<Deporte> deportes = new ArrayList<>();
    static{
        deportes.add(new Deporte("Futbol","Facil"));
        deportes.add(new Deporte("Natacion","Medio"));
        deportes.add(new Deporte("Boxeo","Dificil"));
        deportes.add(new Deporte("Rugby","Dificil"));
    }

    public static List<DeporteDTO> getDeportes(){
        List<DeporteDTO> deportesDto = new ArrayList<>();
        for (Deporte deporte : deportes) {
            deportesDto.add(new DeporteDTO(deporte));
        }
        return deportesDto;
    }

    public static DeporteDTO getDeporteByName(String name){
        Deporte deporte = deportes.stream()
                .filter(d -> d.getNombre().equals(name))
                .findFirst()
                .orElse(null);
        return deporte != null ? new DeporteDTO(deporte) : null;
    }
}
