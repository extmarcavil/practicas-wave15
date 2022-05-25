package com.example.hql_movies.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "genres")
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private String name;

    private Integer ranking;

    private Boolean active;

    @OneToMany(mappedBy = "genres")
    private List<Movies> movies;

    @OneToMany(mappedBy = "genres")
    private List<Series> series;
}
