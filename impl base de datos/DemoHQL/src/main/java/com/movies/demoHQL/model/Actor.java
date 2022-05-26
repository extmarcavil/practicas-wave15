package com.movies.demoHQL.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity @Getter @Setter

public class Actor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String firstName;

    String lastName;

    Double rating;

    @Column(name = "favorite_movie_id")
    Integer favoriteMovieId;

}
