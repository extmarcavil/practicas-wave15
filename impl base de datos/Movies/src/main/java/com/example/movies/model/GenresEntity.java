package com.example.movies.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "genres", schema = "movies_db")
public class GenresEntity {
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
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "ranking")
    private Integer ranking;
    @Basic
    @Column(name = "active")
    private byte active;

    @OneToMany(mappedBy = "genre")
    Set<SeriesEntity>  series;

    @OneToMany(mappedBy = "genre")
    Set<MoviesEntity>  movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenresEntity that = (GenresEntity) o;
        return active == that.active && Objects.equals(id, that.id) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(name, that.name) && Objects.equals(ranking, that.ranking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, name, ranking, active);
    }
}
