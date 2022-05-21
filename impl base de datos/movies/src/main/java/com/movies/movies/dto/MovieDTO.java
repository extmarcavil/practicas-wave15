package com.movies.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private Integer id;
    private String title;
    private Double rating;
    private Integer awards;
    //private Date releaseDate;
    private Integer length;
    private Integer genreId;
}