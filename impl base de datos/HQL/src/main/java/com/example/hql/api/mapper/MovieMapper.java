package com.example.hql.api.mapper;

import com.example.hql.api.dto.MovieDto;
import com.example.hql.entity.Movie;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MovieMapper {
    Movie movieDtoToMovie(MovieDto movieDto);

    MovieDto movieToMovieDto(Movie movie);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateMovieFromMovieDto(MovieDto movieDto, @MappingTarget Movie movie);
}
