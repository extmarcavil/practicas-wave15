package com.example.movies.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "actor_episode", schema = "movies_db")
public class ActorEpisodeEntity {
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
    @ManyToOne
    @JoinColumn(name = "actor_id")
    private ActorsEntity actor;
    @ManyToOne
    @JoinColumn(name = "episode_id", nullable = false)
    private EpisodesEntity episode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorEpisodeEntity that = (ActorEpisodeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(actor, that.actor)
                && Objects.equals(episode, that.episode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, actor, episode);
    }
}
