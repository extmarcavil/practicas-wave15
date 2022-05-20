package com.bootcamp.consultashql.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity @Getter @Setter
@Table(name= "movies")
/*
@NamedQuery(name = "MoviesByAwardsGreaterThan",
            query = "from Movie where awards > :awards")
 */
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    Double rating;
    Integer awards;
    @Column(name = "release_date")
    Date releaseDate;
    Integer length;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }, mappedBy = "actorMoviesById")
    private Set<Actor> actorMoviesById;
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genresByGenreId;
}
