package com.example.movies.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "seasons", schema = "movies_db")
public class SeasonsEntity {
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
    @Column(name = "end_date")
    private Timestamp endDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "serie_id", nullable = false)
    private SeriesEntity serie;

    @OneToMany(mappedBy = "season")
    Set<EpisodesEntity> episodes;
}
