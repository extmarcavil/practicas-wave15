package com.apijoyeria.service;

import com.apijoyeria.dto.request.JoyaRequestDTO;
import com.apijoyeria.dto.response.JoyaResponseDTO;
import com.apijoyeria.dto.response.AccionJoyaResponseDTO;

import java.util.List;

public interface IJoyaService {
    AccionJoyaResponseDTO crearJoya(JoyaRequestDTO joya);

    List<JoyaResponseDTO> todoJoyas();

    AccionJoyaResponseDTO eliminarJoya(int nro_identificatorio);

    JoyaResponseDTO actualizaJoya(int nro_identificatorio,JoyaRequestDTO joya);

}
