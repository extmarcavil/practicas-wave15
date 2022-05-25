package com.example.hql_seguros_auto.service;

import com.example.hql_seguros_auto.dto.SinisterDTO;
import com.example.hql_seguros_auto.dto.VehiclePlateBrandModelDTO;
import com.example.hql_seguros_auto.dto.VehicleSinisterDTO;
import com.example.hql_seguros_auto.entity.Sinister;

import java.util.List;

public interface ISinisterService {
    Sinister saveSinister(SinisterDTO sinisterDTO);

    List<SinisterDTO> getSinisters();

    List<VehiclePlateBrandModelDTO> getVehiclesWithEconomicLossGreaterThan10000();

    VehicleSinisterDTO getVehiclesWithEconomicLossGreaterThan10000AndTotal();
}
