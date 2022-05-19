package com.bootcamp.hql.dto;

import com.bootcamp.hql.model.ActorEpisode;
import com.bootcamp.hql.model.ActorMovie;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class ActorDto {
    private String firstName;
    private String lastName;
    private BigDecimal rating;
    private Integer favoriteMovieId;
    private List<ActorEpisode> actorEpisodesById;
    private List<ActorMovie> actorMoviesById;
}
