package com.example.ejercicioDeportistas.repository;

import com.example.ejercicioDeportistas.dto.DeporteDTO;
import com.example.ejercicioDeportistas.dto.DeportistaDTO;
import com.example.ejercicioDeportistas.model.Deporte;
import com.example.ejercicioDeportistas.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;

@Repository
public class DeporteRepository implements IDeporteRepository{

    ArrayList<DeporteDTO> listaDeportes;
    ArrayList<DeportistaDTO> listaDeportistas;

    @Override
    public ArrayList<DeporteDTO> getAllDeportes() {
        return listaDeportes;
    }

    @Override
    public DeporteDTO getDeporteByName(String nombre) {
        DeporteDTO deporte = listaDeportes.stream().filter(d -> d.getNombre()
                .equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
        return deporte;
    }

    @Override
    public ArrayList<DeportistaDTO> getAllDeportistas() {
        return listaDeportistas;
    }

    public DeporteRepository(){
        listaDeportes = new ArrayList<>();
        listaDeportistas = new ArrayList<>();
        dataInit();
    }

    private void dataInit(){
        DeporteDTO d1 = new DeporteDTO("Futbol","medio");
        DeporteDTO d2 = new DeporteDTO("Tenis","Medio");
        DeporteDTO d3 = new DeporteDTO("Basquet","Avanzado");
        DeporteDTO d4 = new DeporteDTO("Handball","Principiante");
        DeporteDTO d5 = new DeporteDTO("Crossfit","Medio");
        listaDeportes.addAll(Arrays.asList(d1,d2,d3,d4,d5));


        DeportistaDTO depo1 = new DeportistaDTO("Thiago", "Ramirez", "Futbol");
        DeportistaDTO depo2 = new DeportistaDTO("Anti", "Ramirez", "Futbol");
        DeportistaDTO depo3 = new DeportistaDTO("Tricia", "Balderrama", "Tenis");
        DeportistaDTO depo4 = new DeportistaDTO("Theo", "Ramirez", "Handball");
        DeportistaDTO depo5 = new DeportistaDTO("Lola", "Erbin", "Crossfit");

        listaDeportistas.addAll(Arrays.asList(depo1, depo2, depo3, depo4, depo5));
    }

}
