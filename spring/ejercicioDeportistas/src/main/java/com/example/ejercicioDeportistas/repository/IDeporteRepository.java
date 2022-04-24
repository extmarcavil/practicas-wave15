package com.example.ejercicioDeportistas.repository;

import com.example.ejercicioDeportistas.dto.DeporteDTO;
import com.example.ejercicioDeportistas.dto.DeportistaDTO;
import com.example.ejercicioDeportistas.model.Deporte;

import java.util.ArrayList;

public interface IDeporteRepository {

    public ArrayList<DeporteDTO> getAllDeportes();

    public DeporteDTO getDeporteByName(String nombre);

    public ArrayList<DeportistaDTO> getAllDeportistas();

}
