package com.example.hqlmoviesej1.dto;

import com.example.hqlmoviesej1.model.Seasons;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EpisodesDTO {

    private Integer id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String title;

    private Integer number;

    private LocalDateTime releaseDate;

    private Double rating;

    private SeasonsDTO seasons;
}
