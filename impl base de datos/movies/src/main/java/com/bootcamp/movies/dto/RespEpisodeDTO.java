package com.bootcamp.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespEpisodeDTO {
    private Long id;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private Double rating;
    private Set<RespActorDTO> actorEpisodesById;
    private RespSeasonDTO seasonsBySeasonId;
}
