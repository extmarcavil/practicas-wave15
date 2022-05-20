package com.meli.moviesHQL.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity @Getter @Setter
@Table(name= "movies")
@NamedQuery(name = "MoviesByAwardsGreaterThan",
        query = "from Movie where awards > :awards")
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;

    Double rating;

    Integer awards;

    @Column(name = "release_date")
    Date releaseDate;

    Integer length;

    @Column(name  = "genre_id")
    Integer genreId;

}
