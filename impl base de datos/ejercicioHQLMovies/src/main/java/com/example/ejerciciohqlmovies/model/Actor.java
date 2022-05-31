package com.example.ejerciciohqlmovies.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;

    private String lastName;

    private Double rating;

    @Column(name = "favorite_movie_id")
    private Integer favoriteMovieId;
}
