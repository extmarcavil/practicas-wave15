package com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.ProductDTO;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReqSavePurchaseOrderDTO {

    @Positive(message="El ID del usuario no puede ser menor a 0")
    @NotNull(message = "El id del comprador no debe ser nulo.")
    private Integer buyer_id;

    //TODO vale la pena quitar estos valores y setearlos por defecto en el backend?
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @NotEmpty(message = "El estado de la orden no debe estar vacio.")
    private OrderStatusDTO order_status;

    private List<ProductSaveOrderDTO> products;
}