package com.sprint1.be_java_hisp_w15_g03.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sprint1.be_java_hisp_w15_g03.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * US:05
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicationDTO {

    @NotNull(message = "El  id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero.")
    private Integer userId;

    @NotNull(message = "La fecha no puede estar vacía.")
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;

    @Valid
    private ProductDTO detail;

    @NotNull(message = "El campo no puede estar vacío.")
    private Integer category;

    @NotNull(message = "El campo no puede estar vacío.")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private Double price;

}
