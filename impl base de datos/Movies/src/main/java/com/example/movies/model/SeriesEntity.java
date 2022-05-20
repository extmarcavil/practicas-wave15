package com.example.movies.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;
@Data
@Entity
@Table(name = "series", schema = "movies_db")
public class SeriesEntity {
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
    @Column(name = "release_date")
    private Timestamp releaseDate;
    @Basic
    @Column(name = "end_date")
    private Timestamp endDate;
    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private GenresEntity genre;

    @OneToMany(mappedBy = "serie")
    Set<SeasonsEntity> seasons;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeriesEntity that = (SeriesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(title, that.title) && Objects.equals(releaseDate, that.releaseDate) && Objects.equals(endDate, that.endDate) && Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, title, releaseDate, endDate, genre);
    }
}
