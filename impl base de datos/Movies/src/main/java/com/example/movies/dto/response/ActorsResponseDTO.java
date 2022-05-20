package com.example.movies.dto.response;

import com.example.movies.model.ActorEpisodeEntity;
import com.example.movies.model.ActorMovieEntity;
import com.example.movies.model.MoviesEntity;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Data
public class ActorsResponseDTO {

    private String firstName;
    private String lastName;
    private Float rating;
}
