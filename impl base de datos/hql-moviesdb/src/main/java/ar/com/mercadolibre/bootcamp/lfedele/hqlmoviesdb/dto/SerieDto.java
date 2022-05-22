package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class SerieDto {
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;
    private GenreDto genre;
    private Set<SeasonDto> seasons;
}
