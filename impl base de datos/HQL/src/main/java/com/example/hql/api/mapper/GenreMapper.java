package com.example.hql.api.mapper;

import com.example.hql.api.dto.GenreDto;
import com.example.hql.entity.Genre;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface GenreMapper {
    Genre genreDtoToGenre(GenreDto genreDto);

    GenreDto genreToGenreDto(Genre genre);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateGenreFromGenreDto(GenreDto genreDto, @MappingTarget Genre genre);
}
