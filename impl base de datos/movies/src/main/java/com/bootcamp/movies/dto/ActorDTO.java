package com.bootcamp.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ActorDTO {
    private Integer id;
    private Instant createdAt;
    private Instant updatedAt;
    private String firstName;
    private String lastName;
    private BigDecimal rating;
    private MovieDTO favoriteMovie;
}