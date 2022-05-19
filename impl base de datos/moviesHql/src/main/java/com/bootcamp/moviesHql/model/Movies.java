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
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDate release_date;
    private Integer length;
    private Integer genre_id;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }, mappedBy = "movies")
    private Set<Actors> actors;

    public Movies(Integer id, LocalDate created_at, LocalDate updated_at, String title, Double rating, Integer awards, LocalDate release_date, Integer length, Integer genre_id) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.title = title;
        this.rating = rating;
        this.awards = awards;
        this.release_date = release_date;
        this.length = length;
        this.genre_id = genre_id;

    }

    public Movies() {
    }



}
