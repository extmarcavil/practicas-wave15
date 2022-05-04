package com.sprint1.be_java_hisp_w15_g4.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sprint1.be_java_hisp_w15_g4.dto.ProductDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Getter
@Setter
public class PostDTO {
    @NotNull(message = "El  id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero.")
    private int user_id;

    @NotNull(message = "La id_post no puede estar vacia.")
    @Positive(message = "El id_post debe ser mayor a cero.")
    private int post_id;

    @NotNull(message = "La fecha no puede estar vacia.")
    @JsonFormat(pattern = "dd-MM-yyyy",shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private ProductDTO detail;
    private int category;
    private double price;
}
