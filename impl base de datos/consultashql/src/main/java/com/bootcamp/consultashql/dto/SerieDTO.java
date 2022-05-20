package com.bootcamp.consultashql.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SerieDTO {

    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;
    private Long genreId;

}
