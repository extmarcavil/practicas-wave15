package com.bootcamp.movies.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "created_at", nullable = true)
    private LocalDate createdAt;
    @Column(name = "updated_at", nullable = true)
    private LocalDate updatedAt;
    @Column(name = "title", nullable = true, length = 500)
    private String title;
    @Column(name = "number", nullable = true)
    private Integer number;
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;
    @Column(name = "rating", nullable = false)
    private Double rating;
    @ManyToMany(mappedBy = "episodesByEpisodeId")
    private Set<Actor> actorEpisodesById;
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season seasonsBySeasonId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Episode episodes = (Episode) o;
        return Objects.equals(id, episodes.id) && Objects.equals(createdAt, episodes.createdAt) && Objects.equals(updatedAt, episodes.updatedAt) && Objects.equals(title, episodes.title) && Objects.equals(number, episodes.number) && Objects.equals(releaseDate, episodes.releaseDate) && Objects.equals(rating, episodes.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, title, number, releaseDate, rating);
    }
}
