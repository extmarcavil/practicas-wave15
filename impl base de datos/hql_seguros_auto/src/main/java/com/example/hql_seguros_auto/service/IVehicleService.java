package com.example.hql_seguros_auto.service;

import com.example.hql_seguros_auto.dto.VehiclePlateBrandDTO;
import com.example.hql_seguros_auto.dto.VehiclePlateBrandModelDTO;
import com.example.hql_seguros_auto.dto.VehiclePlateDTO;

import java.util.List;

public interface IVehicleService {

    List<VehiclePlateDTO> getVehiclesPlate();

    List<VehiclePlateBrandDTO> getVehiclesPlateBrandOrderByFabricationYear();

    List<VehiclePlateDTO> getVehiclesFourWheelsFabricatedThisYear();
}
