package com.example.ejerciciohqlmovies.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
