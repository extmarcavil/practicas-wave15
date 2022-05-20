package com.example.movies.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "actors", schema = "movies_db")
public class ActorsEntity {
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
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "rating")
    private Float rating;
    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    private MoviesEntity favoriteMovie;

    @OneToMany(mappedBy = "actor")
    Set<ActorEpisodeEntity> actorEpisode;

    @OneToMany(mappedBy = "actor")
    Set<ActorMovieEntity> actorMovie;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorsEntity that = (ActorsEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt)
                && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName)
                && Objects.equals(rating, that.rating) && Objects.equals(favoriteMovie, that.favoriteMovie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, firstName, lastName, rating, favoriteMovie);
    }
}
