package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "rating")
    private Integer rating;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "favorite_movie_id", referencedColumnName = "id")
    private Movie favoriteMovie;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "actor_movie",
            joinColumns = { @JoinColumn(name = "actor_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "movie_id", referencedColumnName = "id") }
    )
    private Set<Movie> movies;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "actor_episode",
            joinColumns = { @JoinColumn(name = "actor_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "episode_id", referencedColumnName = "id") }
    )
    private Set<Episode> episodes;
}
