package com.example.hqlmoviesej1.dto;

import com.example.hqlmoviesej1.model.Genres;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
public class MoviesDTO {
    private Integer id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String title;

    private Integer awards;

    private LocalDateTime releaseDate;

    private Double rating;

    private Integer length;

    private GenresDTO genres;
}
