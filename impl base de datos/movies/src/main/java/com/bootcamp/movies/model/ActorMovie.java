package com.bootcamp.movies.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
@Table(name = "actor_movie")
public class ActorMovie {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "created_at", nullable = true)
    private LocalDate createdAt;
    @Column(name = "updated_at", nullable = true)
    private LocalDate updatedAt;
    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actorsByActorId;
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie moviesByMovieId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorMovie that = (ActorMovie) o;
        return Objects.equals(id, that.id) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt);
    }

}
