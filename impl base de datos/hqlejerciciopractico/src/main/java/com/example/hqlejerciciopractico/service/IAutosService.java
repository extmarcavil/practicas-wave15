package com.example.hqlejerciciopractico.service;

import com.example.hqlejerciciopractico.dto.ResGetOrderMakinDTO;

import java.util.List;

public interface IAutosService {
    List<String> getAllPatentes();

    List<ResGetOrderMakinDTO> getAllOrderMakin();
}
