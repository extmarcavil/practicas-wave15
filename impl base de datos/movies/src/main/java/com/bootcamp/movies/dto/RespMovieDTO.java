package com.bootcamp.movies.dto;

import com.bootcamp.movies.model.Actor;
import com.bootcamp.movies.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
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
