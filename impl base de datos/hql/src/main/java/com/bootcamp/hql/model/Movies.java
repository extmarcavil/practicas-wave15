package com.bootcamp.hql.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Movies {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "created_at")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;
    @Basic
    @Column(name = "updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAt;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "rating")
    private BigDecimal rating;
    @Basic
    @Column(name = "awards")
    private Integer awards;
    @Basic
    @Column(name = "release_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    @Basic
    @Column(name = "length")
    private Integer length;
    @OneToMany(mappedBy = "movieId")
    private List<ActorMovie> actorMoviesById;
    @OneToMany(mappedBy = "favoriteMovieId")
    private List<Actors> actorsById;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genres genresByGenreId;

}
