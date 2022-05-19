package com.bootcamp.movies.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespSeasonDTO {
    private Long id;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private LocalDate endDate;
}
