package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.ReqPostJoyaDto;
import com.bootcamp.joyeria.dto.ResPostJoyaDto;
import com.bootcamp.joyeria.dto.ResPostMessageDto;
import com.bootcamp.joyeria.model.Joya;

import java.util.List;

public interface IJoyaService {

    List<Joya> getJoyas();
    ResPostMessageDto saveJoya(ReqPostJoyaDto joya);
    ResPostMessageDto deleteJoya(Long id);
    Joya findJoyaById(Long id);
    ResPostJoyaDto updateJoya(Long id, ReqPostJoyaDto dto);
}
