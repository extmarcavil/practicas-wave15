package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavoriteDTO {
	@NotNull(message="se debe pasar un user id")
	@Min(value = 1, message="el user id debe ser mayor que 0")
    private Long userId;
	
	@NotNull(message="se debe pasar un product id")
	@Positive(message="el product id debe ser mayor que 0")
    private Long productId;
}
