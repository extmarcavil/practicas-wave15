package com.example.hqlmoviesej1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private String title;

    private Integer awards;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    private Double rating;

    private Integer length;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genres genres;

    @OneToMany(mappedBy = "movies")
    private List<ActorMovie> actors;
}
