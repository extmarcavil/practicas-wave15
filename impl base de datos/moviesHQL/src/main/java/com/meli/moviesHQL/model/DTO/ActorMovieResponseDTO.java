package com.meli.moviesHQL.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ActorMovieResponseDTO {
    ActorDTO actor;
    MovieDTO favoriteMovie;
}
