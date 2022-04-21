package com.modulo6.covid19.service;

import com.modulo6.covid19.model.SintomaDTO;

import java.util.List;

public interface SintomaService {


    List<SintomaDTO> getSintomas();
    SintomaDTO getSintomaNombre(String name);

}
