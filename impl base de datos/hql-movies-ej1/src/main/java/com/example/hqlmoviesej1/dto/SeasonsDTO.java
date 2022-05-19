package com.example.hqlmoviesej1.dto;


import java.time.LocalDateTime;
import java.util.List;

public class SeasonsDTO {

    private Integer id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String title;

    private Integer number;

    private LocalDateTime releaseDate;

    private LocalDateTime endDate;

    private SeriesDTO series;

    private List<EpisodesDTO> episodes;
}
