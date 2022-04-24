package ar.com.mercadolibre.bootcamp.lfedele.youtuber.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EntradaBlog {
    private Long id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
}
