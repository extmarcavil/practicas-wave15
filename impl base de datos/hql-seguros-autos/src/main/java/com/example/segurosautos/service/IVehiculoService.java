package com.example.segurosautos.service;

import com.example.segurosautos.dto.VehiculoPatenteDTO;
import com.example.segurosautos.dto.VehiculoPatenteYMarcaDTO;
import com.example.segurosautos.dto.VehiculoPatenteYMarcaYModeloDTO;
import com.example.segurosautos.dto.VehiculoSiniestroDTO;
import com.example.segurosautos.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    List<VehiculoPatenteDTO> findAllPatente();
    List<VehiculoPatenteYMarcaDTO> findAllVehiculoPatenteAndMarca();
    List<VehiculoPatenteDTO> findVehiculoPatenteByCantRuedasAndCurrentYear();
    List<VehiculoPatenteYMarcaYModeloDTO> findByCostGreaterThan(Double cost);
    VehiculoSiniestroDTO findBySiniestroCostGreaterThanAndTotalCost(Double cost);
    Vehiculo findById(Integer id);
    Vehiculo save(Vehiculo vehiculo);
}
