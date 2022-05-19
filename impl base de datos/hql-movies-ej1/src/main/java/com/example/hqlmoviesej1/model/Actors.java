package com.example.hqlmoviesej1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Actors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private Double rating;

    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    private Movies favouriteMovie;

    @OneToMany(mappedBy = "actors")
    private List<ActorEpisode> episodes;

    @OneToMany(mappedBy = "actors")
    private List<ActorMovie> movies;

}
