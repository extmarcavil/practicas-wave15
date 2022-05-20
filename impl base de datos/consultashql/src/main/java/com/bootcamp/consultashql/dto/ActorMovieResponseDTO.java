package com.bootcamp.consultashql.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ActorMovieResponseDTO {

    ActorDTO actor;
    MovieDTO favoriteMovie;
}
