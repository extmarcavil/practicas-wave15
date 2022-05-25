package com.example.hql_movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenresDTO {
    private Integer id;

    private String name;

    private Integer ranking;

    private Boolean active;
}
