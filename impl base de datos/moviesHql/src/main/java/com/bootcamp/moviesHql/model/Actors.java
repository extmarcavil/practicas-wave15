package com.bootcamp.moviesHql.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "actors")
public class Actors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at", nullable = true)
    private LocalDate created_at;

    @Column(name = "updated_at", nullable = true)
    private LocalDate updated_at;

    @Column(name = "first_name", nullable = true)
    private String first_name;

    @Column(name = "last_name", nullable = true)
    private String last_name;

    @Column(name = "rating", nullable = true)
    private Double rating;

    @Column(name = "favorite_movie_id", nullable = true)
    private Integer favorite_movie_id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(mappedBy = "actors", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    private Set<Movies> movies;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "actor_episode",
            joinColumns = { @JoinColumn(name = "actor_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "episode_id", referencedColumnName = "id") })
    private Set<Episode> episodes;

}
