package com.bootcamp.moviesHql.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "seasons")
public class Season {

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

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "seasonsBySeasonId")
    private List<Episode> episodesById;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie seriesBySerieId;

}