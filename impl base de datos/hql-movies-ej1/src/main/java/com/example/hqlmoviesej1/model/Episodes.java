package com.example.hqlmoviesej1.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Episodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private String title;

    private Integer number;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    private Double rating;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Seasons seasons;

    @OneToMany(mappedBy = "episodes")
    private List<ActorEpisode> actors;
}
