package com.bootcamp.hql.dto;

import com.bootcamp.hql.model.Genres;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MovieDto {
    private String title;
    private BigDecimal rating;
    private Integer awards;
    private LocalDate releaseDate;
    private Integer length;
    private Genres genresByGenreId;
}
