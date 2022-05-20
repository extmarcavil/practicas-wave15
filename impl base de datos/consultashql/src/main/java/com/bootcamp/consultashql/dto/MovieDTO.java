package com.bootcamp.consultashql.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class MovieDTO {

    private Integer id;
    private String title;
    private Double rating;
    private Integer awards;
    private Date releaseDate;
    private Integer length;
    private Integer genreId;
}
