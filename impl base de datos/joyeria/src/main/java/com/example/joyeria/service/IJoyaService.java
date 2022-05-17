package com.example.joyeria.service;

import com.example.joyeria.dto.JoyaRequestDTO;
import com.example.joyeria.dto.JoyaRequestUpdateDTO;
import com.example.joyeria.dto.JoyaResponseDTO;

import java.util.List;

public interface IJoyaService {
    Long save(JoyaRequestDTO joyaDTO);
    void deleteById(Long id);
    List<JoyaResponseDTO> findAll();
    JoyaResponseDTO findById(Long id);
    JoyaResponseDTO updateById(Long joyaId, JoyaRequestUpdateDTO joyaDTO);
}
