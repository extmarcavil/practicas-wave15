package com.bootcamp.hql.dto;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class EpisodeDto {
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private BigDecimal rating;
    private Integer seasonId;
}
