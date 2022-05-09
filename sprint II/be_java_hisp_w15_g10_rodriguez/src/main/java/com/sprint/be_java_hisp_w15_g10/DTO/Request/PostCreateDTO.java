package com.sprint.be_java_hisp_w15_g10.DTO.Request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateDTO {

    @Min(value = 1, message = "El id debe ser mayor a cero")
    @NotNull(message = "El  id no puede estar vacío")
    private Integer user_id;

    @Valid
    @NotNull(message = "no puede ser null")
    private ProductRequestDTO detail;

    @NotNull(message = "La fecha no puede estar vacía")
    @PastOrPresent(message = "La fecha no puede ser de un día posterior a la fecha actual")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @NotNull(message = "El campo no puede estar vacío")
    @Min(value = 1, message = "El category_id debe ser mayor a cero")
    @JsonAlias({"category", "category_id"})
    private Integer category_id;

    @NotNull(message = "El campo no puede estar vacío.")
    @DecimalMin(value = "0", message = "El precio no puede ser 0")
    @DecimalMax(value = "10000000.0", message = "El precio máximo por producto es de 10.000.000")
    private Double price;
}
