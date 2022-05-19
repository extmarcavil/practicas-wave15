package com.movies.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.SecondaryTable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActorDTO {
    private String first_name;
    private String last_name;
    private double rating;
}
