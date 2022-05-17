package com.ejercicio.JoyeriaLasPerlas.service;


import com.ejercicio.JoyeriaLasPerlas.model.Joya;

import java.util.List;

public interface IJoyaService {

    public List<Joya> getJoyas();
    public String saveJoya(Joya joya);
    public String deleteJoya(Long id);
    public Joya findJoya(Long id);
    public String editJoya(Long id, Joya joya);

}
