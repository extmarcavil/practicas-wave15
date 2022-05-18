package com.example.joyeria.service;

import com.example.joyeria.dto.request.ReqJoyaDTO;
import com.example.joyeria.model.JoyaModel;
import com.example.joyeria.repository.JoyaRepository;
import org.springframework.stereotype.Service;

@Service
public class JoyaServiceImp implements JoyaService {

    public final JoyaRepository repo;

    public JoyaServiceImp(JoyaRepository repo){
        this.repo = repo;
    }

    @Override
    public void createJoya() {

    }

    @Override
    public void saveJoya(ReqJoyaDTO joya) {

    }

    @Override
    public void deleteJoya(int nro_identificatorio) {

    }

    @Override
    public void findJoua(int nro_identificatorio) {

    }
}
