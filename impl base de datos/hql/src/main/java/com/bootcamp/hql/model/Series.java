package com.bootcamp.hql.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Series {
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
    @Column(name = "release_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    @Basic
    @Column(name = "end_date")
    private LocalDate endDate;
    //@Basic
   // @Column(name = "genre_id")
   // private Integer genreId;
    @OneToMany(mappedBy = "id")
    private List<Seasons> seasonsById;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genres genresByGenreId;

}
