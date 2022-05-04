package com.spring.ejerciciocovid19.service;

import com.spring.ejerciciocovid19.dtos.SintomaDTO;

import java.util.List;

public interface ISintomaService {
    List<SintomaDTO> getAllSintomas();
    SintomaDTO getSintoma(String name);
}
