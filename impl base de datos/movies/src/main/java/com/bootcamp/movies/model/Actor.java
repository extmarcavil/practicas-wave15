package com.bootcamp.movies.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "created_at", nullable = true)
    private LocalDate createdAt;
    @Column(name = "updated_at", nullable = true)
    private LocalDate updatedAt;
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;
    @Column(name = "rating", nullable = true)
    private Double rating;
    @OneToMany(mappedBy = "actorsByActorId")
    private List<ActorEpisode> actorEpisodesById;
    @OneToMany(mappedBy = "actorsByActorId")
    private List<ActorMovie> actorMoviesById;
    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    private Movie moviesByFavoriteMovieId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actors = (Actor) o;
        return Objects.equals(id, actors.id) && Objects.equals(createdAt, actors.createdAt) && Objects.equals(updatedAt, actors.updatedAt) && Objects.equals(firstName, actors.firstName) && Objects.equals(lastName, actors.lastName) && Objects.equals(rating, actors.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, firstName, lastName, rating);
    }

}
