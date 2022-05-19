package com.example.hqlmoviesej1.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "actor_episode")
public class ActorEpisode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actors actors;

    @ManyToOne
    @JoinColumn(name = "episode_id")
    private Episodes episodes;
}
