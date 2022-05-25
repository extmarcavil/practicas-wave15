package com.example.hql_movies.dto;

import com.example.hql_movies.model.Episodes;
import com.example.hql_movies.model.Series;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeasonsDTO {
    private Integer id;

    private String title;

    private Integer number;

    private LocalDateTime releaseDate;

    private LocalDateTime endDate;

    private List<EpisodesDTO> episodes;
}
