package com.example.joyeria.api.mapper;

import com.example.joyeria.api.dto.NroIdentificatorioDto;
import com.example.joyeria.entity.Jewel;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface NroIdentificatorioMapper {
    @Mapping(source = "nroIdentificatorio", target = "idJewel")
    Jewel nroIdentidicatorioDtoToJewel(NroIdentificatorioDto nroIdentificatorioDto);

    @Mapping(source = "idJewel", target = "nroIdentificatorio")
    NroIdentificatorioDto jewelToNroIdentidicatorioDto(Jewel jewel);

    @Mapping(source = "nroIdentificatorio", target = "idJewel")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateJewelFromNroIdentidicatorioDto(NroIdentificatorioDto nroIdentificatorioDto, @MappingTarget Jewel jewel);
}
