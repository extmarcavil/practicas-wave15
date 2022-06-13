package com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSaveOrderDTO {

    @Positive(message="El ID del producto no debe ser menor a 0")
    @NotNull(message = "El id del producto no debe ser nulo.")
    private Integer product_id;

    @Positive(message="La cantidad del producto no debe ser menor a 0")
    @NotNull(message = "La cantidad del producto no debe ser nulo.")
    private Integer quantity;
}
