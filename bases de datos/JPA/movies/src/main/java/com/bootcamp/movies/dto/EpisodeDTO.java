package com.bootcamp.movies.dto;

import com.bootcamp.movies.model.Season;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDTO {
    private Long id;
    private String title;
    private Integer number;

}
