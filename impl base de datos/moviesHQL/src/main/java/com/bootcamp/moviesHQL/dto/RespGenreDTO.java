package com.bootcamp.moviesHQL.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespGenreDTO {
    private String name;
    private Double ranking;
}
