package com.joyas.ejerciciojoyas.service;

import com.joyas.ejerciciojoyas.dto.request.JoyaRequestDTO;
import com.joyas.ejerciciojoyas.dto.response.JoyaResponseDTO;
import com.joyas.ejerciciojoyas.model.Joya;

import java.util.List;

public interface IJoyaService {
    List<JoyaResponseDTO> getJoyas();
    JoyaResponseDTO saveJoya(JoyaRequestDTO joya);
    void deleteJoya(Long id);
    Joya findJoya(Long id);
    void updateJoya(Long id_modificar,JoyaRequestDTO joyaConDatos);
}
