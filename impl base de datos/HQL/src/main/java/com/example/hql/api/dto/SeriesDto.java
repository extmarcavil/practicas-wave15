package com.example.hql.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class SeriesDto implements Serializable {
    private final Integer id;
    private final String title;
    private final Instant releaseDate;
    private final Instant endDate;
    private final GenreDto genre;
}
