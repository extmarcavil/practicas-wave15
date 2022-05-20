package com.example.segurosautos.service;

import com.example.segurosautos.dto.SiniestroDTO;
import com.example.segurosautos.dto.VehiculoSiniestroDTO;
import com.example.segurosautos.model.Siniestro;

import java.util.List;

public interface ISiniestroService {
    SiniestroDTO save(SiniestroDTO siniestroDTO);
    List<Siniestro> findByCostGreaterThan(Double cost);
    Double findBySiniestroCostGreaterThanAndTotalCost(Double cost);
}
