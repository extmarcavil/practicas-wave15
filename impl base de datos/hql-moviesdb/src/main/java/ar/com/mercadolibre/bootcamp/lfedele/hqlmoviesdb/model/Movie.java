package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {
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

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "awards", nullable = false)
    private Integer awards;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "length")
    private Integer length;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "actor_movie",
            joinColumns = { @JoinColumn(name = "movie_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "actor_id", referencedColumnName = "id") }
    )
    private Set<Actor> actors;
}
