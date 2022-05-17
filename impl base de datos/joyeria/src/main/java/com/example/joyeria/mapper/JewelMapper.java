package com.example.joyeria.mapper;

import com.example.joyeria.dto.JewelDto;
import com.example.joyeria.entity.Jewel;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface JewelMapper {
    Jewel jewelDtoToJewel(JewelDto jewelDto);

    JewelDto jewelToJewelDto(Jewel jewel);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateJewelFromJewelDto(JewelDto jewelDto, @MappingTarget Jewel jewel);
}
