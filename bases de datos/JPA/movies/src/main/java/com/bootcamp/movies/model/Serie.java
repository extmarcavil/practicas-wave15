package com.bootcamp.movies.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "series")
public class Serie {
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
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "seriesBySerieId")
    private List<Season> seasons;
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genres;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie series = (Serie) o;
        return Objects.equals(id, series.id) && Objects.equals(createdAt, series.createdAt) && Objects.equals(updatedAt, series.updatedAt) && Objects.equals(title, series.title) && Objects.equals(releaseDate, series.releaseDate) && Objects.equals(endDate, series.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, title, releaseDate, endDate);
    }
}
