package com.apiconcesionarioautos.service;

import com.apiconcesionarioautos.dto.request.VehicleRequestDTO;
import com.apiconcesionarioautos.dto.response.VehicleResponseDTO;
import com.apiconcesionarioautos.dto.response.VehicleResponseDetailDTO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface IVehicleService {

    List<VehicleResponseDTO> getVehicles();

    boolean addVehicle(VehicleRequestDTO vehicleDTO);

    List<VehicleResponseDTO> getVehiclesRangeDateManufaturing(Date dateStart,Date dateEnd);

    List<VehicleResponseDTO> getVehiclesRangePrice(double priceStart,double priceEnd);

    VehicleResponseDetailDTO getInfoVehicle(int Id);

}
