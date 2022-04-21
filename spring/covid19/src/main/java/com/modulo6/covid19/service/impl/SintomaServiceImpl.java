package com.modulo6.covid19.service.impl;


import com.modulo6.covid19.model.SintomaDTO;
import com.modulo6.covid19.repository.SintomaRepository;
import com.modulo6.covid19.service.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SintomaServiceImpl implements SintomaService {

    @Autowired
    SintomaRepository sintopmaRepository;

//    public SintomaServiceImpl(SintomaRepository sintopmaRepository) {
//        this.sintopmaRepository = sintopmaRepository;
//    }


    @Override
    public List<SintomaDTO> getSintomas() {
        return sintopmaRepository.getAllSintomas();
    }

    @Override
    public SintomaDTO getSintomaNombre(String name) {
        return sintopmaRepository.getFindByName(name);
    }
}
