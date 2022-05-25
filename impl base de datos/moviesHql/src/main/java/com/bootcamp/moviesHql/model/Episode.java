package com.bootcamp.moviesHql.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
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

    @ManyToMany(mappedBy = "actorEpisodesById")
    private Set<Actors> actorEpisodesById;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season seasonsBySeasonId;

}
