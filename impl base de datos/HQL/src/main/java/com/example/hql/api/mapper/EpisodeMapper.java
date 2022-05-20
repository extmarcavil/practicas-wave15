package com.example.hql.api.mapper;

import com.example.hql.api.dto.EpisodeDto;
import com.example.hql.entity.Episode;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EpisodeMapper {
    Episode episodeDtoToEpisode(EpisodeDto episodeDto);

    EpisodeDto episodeToEpisodeDto(Episode episode);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEpisodeFromEpisodeDto(EpisodeDto episodeDto, @MappingTarget Episode episode);
}
