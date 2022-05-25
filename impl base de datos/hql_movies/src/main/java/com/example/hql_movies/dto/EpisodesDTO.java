package com.example.hql_movies.dto;


import com.example.hql_movies.model.ActorEpisode;
import com.example.hql_movies.model.Seasons;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EpisodesDTO {
    private Integer id;

    private String title;

    private Integer number;

    private LocalDateTime releaseDate;

    private Double rating;
}
