package com.bootcamp.movies.dto;

import com.bootcamp.movies.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieDTO {
    private Integer id;
    private Instant createdAt;
    private Instant updatedAt;
    private String title;
    private Integer awards;
    private Instant releaseDate;
    private Integer length;
    private GenreDTO genre;
    private Float rating;
}