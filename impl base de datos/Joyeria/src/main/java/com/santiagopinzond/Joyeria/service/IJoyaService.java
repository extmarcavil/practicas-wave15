package com.santiagopinzond.Joyeria.service;

import com.santiagopinzond.Joyeria.dto.JoyaDto;

import java.util.List;

public interface IJoyaService {
    public Long createJoya(JoyaDto joyaDto);
    public List<JoyaDto> getAllJoyas();
    public void deleteJoya(Long id);
    public JoyaDto updateJoya(Long id, JoyaDto joyaDto);
}
