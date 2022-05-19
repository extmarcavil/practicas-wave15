package com.movies.demoHQL.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity @Getter @Setter
@Table(name= "actors")
public class Actor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String firstName;

    String lastName;

    Double rating;

    @Column(name = "favorite_movie_id")
    Integer favoriteMovieId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "actor_movie",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<Movie> actorMoviesById;

}
