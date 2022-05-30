package com.meli.seguro.api.mapper;

import com.meli.seguro.api.dto.VehicleOnlyDto;
import com.meli.seguro.entity.Vehicle;
import com.meli.seguro.api.dto.VehicleDto;
import com.meli.seguro.api.dto.VehiclePatenteMarcaModeloDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface VehicleMapper {
    Vehicle vehicleOnlyDtoToVehicle(VehicleOnlyDto vehicleOnlyDto);

    VehicleOnlyDto vehicleToVehicleOnlyDto(Vehicle vehicle);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateVehicleFromVehicleOnlyDto(VehicleOnlyDto vehicleOnlyDto, @MappingTarget Vehicle vehicle);

    Vehicle vehicleDtoToVehicle(VehicleDto vehicleDto);

    VehicleDto vehicleToVehicleDto(Vehicle vehicle);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateVehicleFromVehicleDto(VehicleDto vehicleDto, @MappingTarget Vehicle vehicle);

    @AfterMapping
    default void linkAccidents(@MappingTarget Vehicle vehicle) {
        vehicle.getAccidents().forEach(accident -> accident.setVehicle(vehicle));
    }

    VehiclePatenteMarcaModeloDto vehicleToVehiclePatenteMarcaModeloDto(Vehicle vehicle);

}
