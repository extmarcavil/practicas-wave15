package com.be.java.hisp.w156.be.java.hisp.w156.dto.request;

import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestPostDTO {

    @NotNull(message = "El id no puede estar vacío.")
    @Min(value = 1, message = "El id debe ser mayor a cero.")
    private Integer user_id;

    //@JsonSerialize(using = JsonAdapterSerializer.class)
    //@JsonDeserialize(using = JsonAdapterDeserializer.class)
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    @NotNull(message = "La fecha no puede estar vacía.")
    @FutureOrPresent(message = "La fecha no puede ser anterior a hoy.")
    private LocalDate date;

    @Valid
    @NotNull
    private ProductDTO detail;

    @NotEmpty(message = "El campo no puede estar vacío.")
    private String category;

    @NotNull(message = "El campo no puede estar vacío.")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private Double price;

}
