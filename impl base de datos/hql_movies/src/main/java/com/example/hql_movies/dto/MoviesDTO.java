package com.example.hql_movies.dto;

import com.example.hql_movies.model.Genres;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoviesDTO {
    private Integer id;

    private String title;

    private Integer awards;

    private LocalDateTime releaseDate;

    private Double rating;

    private Integer length;

    private GenresDTO genres;
}
