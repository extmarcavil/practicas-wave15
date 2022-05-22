package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EpisodeDto {
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private Integer rating;
}
