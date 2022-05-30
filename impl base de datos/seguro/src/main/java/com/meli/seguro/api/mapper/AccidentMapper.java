package com.meli.seguro.api.mapper;

import com.meli.seguro.api.dto.AccidentOnlyDto;
import com.meli.seguro.entity.Accident;
import com.meli.seguro.api.dto.AccidentDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccidentMapper {
    Accident accidentOnlyDtoToAccident(AccidentOnlyDto accidentOnlyDto);

    AccidentOnlyDto accidentToAccidentOnlyDto(Accident accident);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAccidentFromAccidentOnlyDto(AccidentOnlyDto accidentOnlyDto, @MappingTarget Accident accident);

    Accident accidentDtoToAccident(AccidentDto accidentDto);

    AccidentDto accidentToAccidentDto(Accident accident);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAccidentFromAccidentDto(AccidentDto accidentDto, @MappingTarget Accident accident);
}
