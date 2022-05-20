package com.example.movies.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "movies", schema = "movies_db")
public class MoviesEntity {
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
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "rating")
    private Float rating;
    @Basic
    @Column(name = "awards")
    private Integer awards;
    @Basic
    @Column(name = "release_date")
    private Timestamp releaseDate;
    @Basic
    @Column(name = "length")
    private Integer length;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenresEntity genre;

    @OneToMany(mappedBy = "favoriteMovie")
    Set<ActorsEntity> actors;

    @OneToMany(mappedBy = "movie")
    Set<ActorMovieEntity> actorMovie;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesEntity that = (MoviesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(title, that.title)
                && Objects.equals(rating, that.rating) && Objects.equals(awards, that.awards)
                && Objects.equals(releaseDate, that.releaseDate) && Objects.equals(length, that.length)
                && Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, title, rating, awards, releaseDate, length, genre);
    }
}
