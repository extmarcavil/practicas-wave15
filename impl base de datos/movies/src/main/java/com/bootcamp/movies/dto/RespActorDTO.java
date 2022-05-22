package com.bootcamp.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespActorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Double rating;
}
