package com.spring.ejerciciocovid19.service;

import com.spring.ejerciciocovid19.dtos.Persona;
import com.spring.ejerciciocovid19.dtos.SintomaDTO;
import com.spring.ejerciciocovid19.repository.ISintomaRepository;
import com.spring.ejerciciocovid19.repository.SintomaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SintomaService implements ISintomaService{

    ISintomaRepository repository;

    public SintomaService(ISintomaRepository repository) {
        this.repository = repository;
    }

    public List<SintomaDTO> getAllSintomas() {
        return repository.getAllSintomas();
    }

    public SintomaDTO getSintoma(String name) {
        return repository.getSintomaByName(name).orElse(null);
    }




}
