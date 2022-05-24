package com.example.hql_movies.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
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
