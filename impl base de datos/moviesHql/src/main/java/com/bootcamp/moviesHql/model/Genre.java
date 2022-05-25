package com.bootcamp.moviesHql.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
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

    @OneToMany(mappedBy = "genresByGenreId")
    private List<Serie> seriesById;

}