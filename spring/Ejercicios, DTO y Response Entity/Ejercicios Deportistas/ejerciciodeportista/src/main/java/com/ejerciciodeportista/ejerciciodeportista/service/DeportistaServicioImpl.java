package com.ejerciciodeportista.ejerciciodeportista.service;

import com.ejerciciodeportista.ejerciciodeportista.dto.DeportistaDTO;
import com.ejerciciodeportista.ejerciciodeportista.repository.DeportistaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeportistaServicioImpl implements DeportistaServicio{
    DeportistaRepository deportistaRepository;

    public DeportistaServicioImpl(DeportistaRepository deportistaRepository){
       this.deportistaRepository = deportistaRepository;
    }

    @Override
    public List<DeportistaDTO> listarDeportistas() {
        return deportistaRepository.listarDeportistas();
    }
}
