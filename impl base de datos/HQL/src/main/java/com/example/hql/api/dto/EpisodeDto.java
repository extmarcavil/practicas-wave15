package com.example.hql.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data
public class EpisodeDto implements Serializable {
    private final Integer id;
    private final Integer number;
    private final String title;
    private final BigDecimal rating;
    private final Instant releaseDate;
    private final SeasonDto season;
}
