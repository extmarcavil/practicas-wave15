package com.example.hql.api.mapper;

import com.example.hql.api.dto.SeasonDto;
import com.example.hql.entity.Season;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SeasonMapper {
    Season seasonDtoToSeason(SeasonDto seasonDto);

    SeasonDto seasonToSeasonDto(Season season);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSeasonFromSeasonDto(SeasonDto seasonDto, @MappingTarget Season season);
}
