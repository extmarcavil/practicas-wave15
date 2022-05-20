package com.example.hql.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@RequiredArgsConstructor
public class MovieDto implements Serializable {
    private final Integer id;
    private final String title;
    private final Integer awards;
    private final Instant releaseDate;
    private final Integer length;
    private final GenreDto genre;
}
