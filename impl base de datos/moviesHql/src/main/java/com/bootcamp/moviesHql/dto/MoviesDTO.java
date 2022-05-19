package com.bootcamp.moviesHql.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviesDTO {

    private Integer id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDate relase_date;
    private Integer length;
    private Integer genre_id;



}
