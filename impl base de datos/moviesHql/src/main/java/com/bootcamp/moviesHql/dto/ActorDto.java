package com.bootcamp.moviesHql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto {

    private Integer id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String first_name;
    private String last_name;
    private Double rating;
}
