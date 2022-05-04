package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class WhoAndHowManyFollowsMeRequestDTO {
    @NotNull(message = "El  id no puede estar vacío.")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private Long userId;

    @Pattern(
            regexp = "name_asc|name_desc|date_asc|date_desc",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "No es un parametro de ordenamiento valido"
    )
    private String order;
}
