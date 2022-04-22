package com.bootcamp.deportistas.Repository;

import com.bootcamp.deportistas.dtos.DeporteDTO;
import com.bootcamp.deportistas.models.Deporte;

import java.util.ArrayList;
import java.util.List;

public class DeporteRepository {

    static List<Deporte> listaDeporte = new ArrayList<>();
    static {
        listaDeporte.add(new Deporte("futbol", "b"));
        listaDeporte.add(new Deporte("basquetbool", "b"));
        listaDeporte.add(new Deporte("natacion", "b"));
    }

    public static List<DeporteDTO> obtenerDeporte(){
        List<DeporteDTO> listDTO = new ArrayList<>();
        for (Deporte d : listaDeporte){
            listDTO.add(new DeporteDTO(d));
        }
        return listDTO;
    }

    public static DeporteDTO obtenerDeportePorNombre(String nombre) {
        Deporte deporte = listaDeporte.stream().filter(d -> d.getNombre().equals(nombre)).findFirst().orElse(null);
        return deporte != null ? new DeporteDTO(deporte) : null;
    }

}
