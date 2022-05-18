package com.example.joyeria.service;

import com.example.joyeria.model.JoyaModel;
import com.example.joyeria.repository.JoyaRepository;

public interface JoyaService {

    public void createJoya();
    public void saveJoya(JoyaModel joya); //AIUDA
    public void deleteJoya(int nro_identificatorio);
    public void findJoua(int nro_identificatorio);

}
x