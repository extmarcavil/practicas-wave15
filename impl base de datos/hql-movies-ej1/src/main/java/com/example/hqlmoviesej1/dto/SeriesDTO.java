package com.example.hqlmoviesej1.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SeriesDTO {
    private Integer id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String title;

    private LocalDateTime releaseDate;

    private LocalDateTime endDate;

    private GenresDTO genres;
}
