package com.example.hql_movies.dto;

import com.example.hql_movies.model.Movies;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorsDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private BigDecimal rating;

    private MoviesDTO favoriteMovie;
}
