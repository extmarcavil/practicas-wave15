package com.bootcamp.movies.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "created_at", nullable = true)
    private LocalDate createdAt;
    @Column(name = "updated_at", nullable = true)
    private LocalDate updatedAt;
    @Column(name = "title", nullable = false, length = 500)
    private String title;
    @Column(name = "rating", nullable = false)
    private Double rating;
    @Column(name = "awards", nullable = false)
    private Integer awards;
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;
    @Column(name = "length", nullable = true)
    private Integer length;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "actorMoviesById")
    private Set<Actor> actorMoviesById;
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "moviesByFavoriteMovieId")
    private List<Actor> actorsById;
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genresByGenreId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movies = (Movie) o;
        return Objects.equals(id, movies.id) && Objects.equals(createdAt, movies.createdAt) && Objects.equals(updatedAt, movies.updatedAt) && Objects.equals(title, movies.title) && Objects.equals(rating, movies.rating) && Objects.equals(awards, movies.awards) && Objects.equals(releaseDate, movies.releaseDate) && Objects.equals(length, movies.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, title, rating, awards, releaseDate, length);
    }
}
