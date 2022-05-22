package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MovieDto {
    private String title;
    private Integer rating;
    private Integer awards;
    private LocalDate releaseDate;
    private Integer length;
    private GenreDto genre;
}
