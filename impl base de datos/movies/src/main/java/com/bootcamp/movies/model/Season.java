package com.bootcamp.movies.model;

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
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "seasonsBySeasonId")
    private List<Episode> episodesById;
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinColumn(name = "serie_id")
    private Serie seriesBySerieId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Season seasons = (Season) o;
        return Objects.equals(id, seasons.id) && Objects.equals(createdAt, seasons.createdAt) && Objects.equals(updatedAt, seasons.updatedAt) && Objects.equals(title, seasons.title) && Objects.equals(number, seasons.number) && Objects.equals(releaseDate, seasons.releaseDate) && Objects.equals(endDate, seasons.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, title, number, releaseDate, endDate);
    }
}
