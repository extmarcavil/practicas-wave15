package com.bootcamp.movies.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
@Data
public class SerieDTO {
    private Long id;
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;

    public SerieDTO() {
    }
}
