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
@Table(name = "movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at", nullable = true)
    private LocalDate created_at;

    @Column(name = "updated_at", nullable = true)
    private LocalDate updated_at;

    @Column(name = "title", nullable = true)
    private String title;

    @Column(name = "rating", nullable = true)
    private Double rating;

    @Column(name = "awards", nullable = true)
    private Integer awards;

    @Column(name = "relase_date", nullable = true)
    private LocalDate relase_date;

    @Column(name = "length", nullable = true)
    private Integer length;

    @Column(name = "genre_id", nullable = true)
    private Integer genre_id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany
    @JoinTable(name = "actor_movie", joinColumns = @JoinColumn (name = "movie_id"),
               inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actors> actors;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;

}
