package com.example.hql.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ActorDto implements Serializable {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final BigDecimal rating;
    private final MovieDto favoriteMovie;
}
