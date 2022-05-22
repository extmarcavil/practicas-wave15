package com.example.demo.service;

import com.example.demo.DTO.JoyaDTO;
import com.example.demo.DTO.JoyaRespDTO;
import com.example.demo.model.Joya;

import java.util.List;


public interface IServiceJoya {
     List<JoyaRespDTO> getJoyas();
     Long saveJoya(JoyaDTO joya);
     void deleteJoya (Long idJoya);
     JoyaRespDTO findJoya(Long idJoya);
     void deleteJoyaLogico(Long idJoya);
     void editJoya(Long id, JoyaDTO joya);
}
