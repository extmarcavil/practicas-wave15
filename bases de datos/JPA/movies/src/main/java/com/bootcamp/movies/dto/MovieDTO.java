package com.bootcamp.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private Long id;
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDate releaseDate;
    private Integer length;
    private List<ActorDTO> actorMovies;
    private GenreDTO genre;
}
