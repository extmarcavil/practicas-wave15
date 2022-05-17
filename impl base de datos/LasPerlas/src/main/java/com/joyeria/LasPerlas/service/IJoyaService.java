package com.joyeria.LasPerlas.service;

import com.joyeria.LasPerlas.model.Joya;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IJoyaService {
    List<Joya> getJoyas();
    void saveJoya(Joya joya);
    void deleteJoya(Long id);
    Joya findJoya(Long id);
}
