package com.movies.demoHQL.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ActorDTO {

    Integer id;
    String firstName;
    String lastName;
    Double rating;
    Integer favoriteMovieId;

}