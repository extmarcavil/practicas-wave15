package com.ejercicio.joyeria.service;

import com.ejercicio.joyeria.dto.JoyaDTO;
import com.ejercicio.joyeria.model.Joya;

import java.util.List;

public interface IJoyaService {

    Long saveJoya(JoyaDTO joya);
    List<JoyaDTO> getJoyas();
    JoyaDTO findJoya(Long id);
    void deleteJoya(long id);
    JoyaDTO editJoya(long id_modify, JoyaDTO jewelDTO);

}
