package com.example.ejerciciocovid.service;

import com.example.ejerciciocovid.model.Sintoma;
import com.example.ejerciciocovid.repository.SintomaRepository;

import java.util.List;

public class SintomaService {

    private SintomaRepository sintomaRepo = new SintomaRepository();

    public SintomaService() {
    }

    public List<Sintoma> getSintomasList() { return sintomaRepo.getSintomasList(); }

    public Sintoma getSintomaByName(String name) {
        return sintomaRepo.getSintomasList().stream()
                .filter(x -> x.getNombre().equals(name))
                .findFirst().orElse(null);
    }
}
