package com.example.hql.api.dto;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Getter @Setter
@RequiredArgsConstructor
public class SeasonDto implements Serializable {
    private final String title;
    private final Instant releaseDate;
    private final Instant endDate;
    private final SeriesMinimalDto serie;
}
