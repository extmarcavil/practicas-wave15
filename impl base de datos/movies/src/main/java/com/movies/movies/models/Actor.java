package com.movies.movies.models;

import lombok.*;
import org.hibernate.mapping.Join;
import org.hibernate.mapping.Set;
import org.springframework.stereotype.Service;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String first_name;
    private String last_name;
    private Double rating;
    private Integer favorite_movie_id;

    @ManyToMany
    @JoinTable(
            name = "actor_movie",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    List<Movie> movies;
}
