package com.example.movies.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "episodes", schema = "movies_db")
public class EpisodesEntity {
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
    @Column(name = "number")
    private Integer number;
    @Basic
    @Column(name = "release_date")
    private Timestamp releaseDate;
    @Basic
    @Column(name = "rating")
    private Float rating;
    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    private SeasonsEntity season;

    @OneToMany(mappedBy = "episode")
    private Set<ActorEpisodeEntity> episodes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EpisodesEntity that = (EpisodesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(title, that.title)
                && Objects.equals(number, that.number) && Objects.equals(releaseDate, that.releaseDate)
                && Objects.equals(rating, that.rating) && Objects.equals(season, that.season);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, title, number, releaseDate, rating, season);
    }
}
