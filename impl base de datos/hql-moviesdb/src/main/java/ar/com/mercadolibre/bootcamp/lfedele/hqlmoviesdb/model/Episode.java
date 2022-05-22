package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "number")
    private Integer number;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "season_id")
    @JsonBackReference
    private Season season;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "actor_episode",
            joinColumns = { @JoinColumn(name = "episode_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "actor_id", referencedColumnName = "id") }
    )
    private Set<Actor> actors;
}
