package ar.com.mercadolibre.bootcamp.lfedele.youtuber.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EntradaBlogDto {
    private Long id;
    private String titulo;
    private String autor;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaPublicacion;
}
