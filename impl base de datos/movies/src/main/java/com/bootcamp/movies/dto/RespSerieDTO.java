package com.bootcamp.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespSerieDTO {
    private Long id;
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;
    private List<RespSeasonDTO> seasonsById;
    private RespGenreDTO genresByGenreId;
}
