package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreDto {
    private String name;
    private Integer ranking;
    private Integer active;
}
