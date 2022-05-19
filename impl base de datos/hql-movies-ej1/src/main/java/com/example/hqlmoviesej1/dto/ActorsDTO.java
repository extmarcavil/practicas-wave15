package com.example.hqlmoviesej1.dto;

import com.example.hqlmoviesej1.model.Movies;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
public class ActorsDTO {

    private Integer id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String firstName;

    private String lastName;

    private Double rating;

    private MoviesDTO favouriteMovie;
}
