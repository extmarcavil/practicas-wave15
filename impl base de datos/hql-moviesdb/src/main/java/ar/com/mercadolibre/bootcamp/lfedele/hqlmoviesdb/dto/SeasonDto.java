package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class SeasonDto {
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private LocalDate endDate;
    private Set<EpisodeDto> episodes;
}
