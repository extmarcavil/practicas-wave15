package com.example.hql.api.mapper;

import com.example.hql.api.dto.SeriesDto;
import com.example.hql.api.dto.SeriesMinimalDto;
import com.example.hql.entity.Series;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SeriesMapper {
    Series seriesDtoToSeries(SeriesDto seriesDto);

    SeriesDto seriesToSeriesDto(Series series);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSeriesFromSeriesDto(SeriesDto seriesDto, @MappingTarget Series series);

    Series seriesMinimalDtoToSeries(SeriesMinimalDto seriesMinimalDto);

    SeriesMinimalDto seriesToSeriesMinimalDto(Series series);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSeriesFromSeriesMinimalDto(SeriesMinimalDto seriesMinimalDto, @MappingTarget Series series);
}
