package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ActorDto {
    private String firstName;
    private String lastName;
    private Integer rating;
    private MovieDto favoriteMovie;
    private Set<MovieDto> movies;
    private Set<EpisodeDto> episodes;
}
