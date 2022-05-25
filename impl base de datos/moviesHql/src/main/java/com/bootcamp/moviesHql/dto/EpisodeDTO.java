package com.bootcamp.moviesHql.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDTO {

    private Long id;
    private String title;
    private Integer number;
    private Double rating;

}
