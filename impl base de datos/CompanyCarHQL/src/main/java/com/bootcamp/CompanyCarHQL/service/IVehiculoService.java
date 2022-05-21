package com.bootcamp.CompanyCarHQL.service;

import com.bootcamp.CompanyCarHQL.DTO.SiniestroDto;
import com.bootcamp.CompanyCarHQL.DTO.VehiculoDto;

import java.util.List;

public interface IVehiculoService {
    public VehiculoDto crearVehiculo(VehiculoDto vehiculoDto);
    public List<VehiculoDto> getAllVehiculos();
    public void crearSiniestro(SiniestroDto siniestroDto);
    public List<SiniestroDto> getAllSiniestros();


}
