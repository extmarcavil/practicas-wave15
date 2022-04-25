package com.ejerciciodeportista.ejerciciodeportista.service;

import com.ejerciciodeportista.ejerciciodeportista.dto.DeporteDTO;
import com.ejerciciodeportista.ejerciciodeportista.repository.DeporteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeporteServicioImpl implements DeporteServicio{
    DeporteRepository deporteRepository;

    public DeporteServicioImpl(DeporteRepository deporteRepository){
        this.deporteRepository = deporteRepository;
    }

    @Override
    public List<DeporteDTO> listarDeportes() {
        return deporteRepository.listarDeportes();
    }

    @Override
    public String buscarDeporte(String nombre) {
        return deporteRepository.buscarDeporte(nombre);
    }
}
