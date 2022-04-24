package ar.com.mercadolibre.bootcamp.lfedele.concecionaria.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VehicleDto {
    private Long id;
    private String brand;
    private String model;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fabricationDate;
    private Integer price;
}
