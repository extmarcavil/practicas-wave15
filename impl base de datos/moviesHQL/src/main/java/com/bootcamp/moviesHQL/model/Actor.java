package com.bootcamp.moviesHQL.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name= "actors")
public class Actor {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "created_at")
    private LocalDate created_at;
    @Column(name = "updated_at")
    private LocalDate updated_at;
    @Column(name = "first_name", nullable = false, length = 100)
    private String first_name;
    @Column(name = "last_name", nullable = false, length = 100)
    private String last_name;
    @Column(name = "rating")
    private Double rating;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "actor_episode",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "episode_id"))
    private Set<Episode> actorEpisodesById;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "actor_movie", joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> actorMoviesById;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "favorite_movie_id")
    private Movie moviesByFavoriteMovieId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actors = (Actor) o;
        return Objects.equals(id, actors.id) && Objects.equals(createdAt, actors.createdAt) &&
                Objects.equals(updatedAt, actors.updatedAt) && Objects.equals(firstName, actors.firstName) &&
                Objects.equals(lastName, actors.lastName) && Objects.equals(rating, actors.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, firstName, lastName, rating);
    }
}
