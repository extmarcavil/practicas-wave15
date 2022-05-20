package com.example.EjercicioJoyeria.service;

import com.example.EjercicioJoyeria.model.Joya;

import java.util.List;

public interface IJoyaService {

    public String createJoya(Joya joya);

    public List<Joya> listaJoyas();

    public String deleteJoya(Long id);

    public String updateJoya(Long id, Joya joya);

}
