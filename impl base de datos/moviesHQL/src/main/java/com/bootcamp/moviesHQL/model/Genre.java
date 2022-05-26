package com.bootcamp.moviesHQL.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "created_at", nullable = true)
    private LocalDate createdAt;
    @Column(name = "updated_at", nullable = true)
    private LocalDate updatedAt;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "ranking", nullable = false)
    private Double ranking;
    @Column(name = "active", nullable = false)
    private boolean active;
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "genresByGenreId")
    private List<Movie> moviesById;
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "genresByGenreId")
    private List<Serie> seriesById;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genres = (Genre) o;
        return active == genres.active && Objects.equals(id, genres.id) && Objects.equals(createdAt, genres.createdAt) && Objects.equals(updatedAt, genres.updatedAt) && Objects.equals(name, genres.name) && Objects.equals(ranking, genres.ranking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, name, ranking, active);
    }
}
