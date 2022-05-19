package com.bootcamp.hql.dto;

import com.bootcamp.hql.model.Genres;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SerieDto {
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;
    private Genres genresByGenreId;
}
