package com.apiconcesionarioautos.service;

import com.apiconcesionarioautos.dto.request.VehicleRequestDTO;
import com.apiconcesionarioautos.dto.response.VehicleResponseDTO;
import com.apiconcesionarioautos.dto.response.VehicleResponseDetailDTO;
import com.apiconcesionarioautos.model.Vehicle;
import com.apiconcesionarioautos.repository.IVehicleRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VehicleService implements IVehicleService {

    //region Variables
    private IVehicleRepository _vehicleRepository;
    private ModelMapper _mapper;
    //endregion

    //region Constructor

    public VehicleService(IVehicleRepository vehicleRepository) {
        this._vehicleRepository = vehicleRepository;
        _mapper = new ModelMapper();
    }

    //endregion

    //region Implementacion

    @Override
    public List<VehicleResponseDTO> getVehicles() {
        var listType = new TypeToken<List<VehicleResponseDTO>>(){}.getType();
        return _mapper.map(_vehicleRepository.getAll(),listType);
    }

    @Override
    public boolean addVehicle(VehicleRequestDTO vehicleDTO) {
        _vehicleRepository.add(_mapper.map(vehicleDTO, Vehicle.class));
        return true;
    }

    @Override
    public List<VehicleResponseDTO> getVehiclesRangeDateManufaturing(Date dateStart, Date dateEnd) {
        List<VehicleResponseDTO> listResult = new ArrayList<>();
        return _mapper.map(_vehicleRepository.getDateManufaturingRange(dateStart,dateEnd),listResult.getClass());
    }

    @Override
    public List<VehicleResponseDTO> getVehiclesRangePrice(double priceStart,double priceEnd) {
        List<VehicleResponseDTO> listResult = new ArrayList<>();
        return _mapper.map(_vehicleRepository.getPriceRange(priceStart,priceEnd),listResult.getClass());
    }

    @Override
    public VehicleResponseDetailDTO getInfoVehicle(int Id) {
        var info = _vehicleRepository.getInfoById(Id);
        if(info != null)
            return _mapper.map(info,VehicleResponseDetailDTO.class);
        else
            return  null;
    }

    //endregion
}
