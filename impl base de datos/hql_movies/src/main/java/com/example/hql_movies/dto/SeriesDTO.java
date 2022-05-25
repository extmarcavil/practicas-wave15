package com.example.hql_movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeriesDTO {
    private Integer id;

    private String title;

    private LocalDateTime releaseDate;

    private LocalDateTime endDate;

    private GenresDTO genres;

    private List<SeasonsDTO> seasons;
}