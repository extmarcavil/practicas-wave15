package com.example.movies.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "actor_movie", schema = "movies_db")
public class ActorMovieEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false)
    private ActorsEntity actor;
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private MoviesEntity movie;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorMovieEntity that = (ActorMovieEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt)
                && Objects.equals(actor, that.actor) && Objects.equals(movie, that.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, actor, movie);
    }
}
