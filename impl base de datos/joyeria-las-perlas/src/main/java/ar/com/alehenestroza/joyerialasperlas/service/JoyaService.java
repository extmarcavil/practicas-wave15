package ar.com.alehenestroza.joyerialasperlas.service;

import ar.com.alehenestroza.joyerialasperlas.dto.request.JoyaDTO;
import ar.com.alehenestroza.joyerialasperlas.model.Joya;

import java.util.List;

public interface JoyaService {
    List<Joya> getJoyas();
    Long saveJoya(JoyaDTO joya);
    Long deleteJoya(Long id);
    Joya findJoya(Long id);
    Joya update(Long id, JoyaDTO joyaDTO);
}
