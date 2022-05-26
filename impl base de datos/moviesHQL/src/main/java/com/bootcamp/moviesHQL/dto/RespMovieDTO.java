package com.bootcamp.moviesHQL.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespMovieDTO {
    private Long id;
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDate releaseDate;
    private Integer length;
    private Set<RespActorDTO> actorMoviesById;
    private RespGenreDTO genresByGenreId;
}
