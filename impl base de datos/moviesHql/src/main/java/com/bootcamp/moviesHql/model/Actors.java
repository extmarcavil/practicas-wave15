package com.bootcamp.moviesHql.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
public class Actors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String first_name;
    private String last_name;
    private Double rating;

    private Integer favorite_movie_id;

    @ManyToMany(fetch= FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "actor_movie",
            joinColumns = @JoinColumn (name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<Movies> movies;

    public Actors(Integer id, LocalDate created_at, LocalDate updated_at, String first_name, String last_name, Double rating, Integer favorite_movie_id) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.first_name = first_name;
        this.last_name = last_name;
        this.rating = rating;
        this.favorite_movie_id = favorite_movie_id;

    }


    public Actors() {

    }


}
