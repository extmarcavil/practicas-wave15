package com.example.ejercicioDeportistas.service;

import com.example.ejercicioDeportistas.dto.DeporteDTO;
import com.example.ejercicioDeportistas.dto.DeportistaDTO;
import com.example.ejercicioDeportistas.model.Deporte;
import com.example.ejercicioDeportistas.repository.IDeporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DeporteService {

    IDeporteRepository iDeporteRepository;

    public DeporteService(IDeporteRepository deporteRepository){
        this.iDeporteRepository = deporteRepository;
    }

    public ArrayList<DeporteDTO> getAllDeportes(){
        ArrayList<DeporteDTO> listaDeporte = iDeporteRepository.getAllDeportes();
        return listaDeporte;
    }

    public DeporteDTO getDeporteByName(String nombre){
        DeporteDTO deportedto = iDeporteRepository.getDeporteByName(nombre);
        return deportedto;
    }

    public ArrayList<DeportistaDTO> getDeportistas(){
        ArrayList<DeportistaDTO> listaDeportistas = iDeporteRepository.getAllDeportistas();
        return listaDeportistas;
    }

}
