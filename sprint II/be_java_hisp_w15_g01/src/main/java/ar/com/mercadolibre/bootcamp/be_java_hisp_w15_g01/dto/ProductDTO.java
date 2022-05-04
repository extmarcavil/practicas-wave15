package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @NotNull(message = Constants.ID_NOT_NULL)
    @Min(value = Constants.ID_VALUE, message = Constants.ID_NOT_ZERO)
    private Long productId;

    @NotBlank(message = Constants.NOMBRE_NOT_NULL)
    @Size(max = Constants.NAME_VALUE, message = Constants.NOMBRE_MAX_VALUE)
    @Pattern(regexp = Constants.SIMBOLS_REGEX, message = Constants.NOMBRE_REGEX)
    private String productName;

    @NotBlank(message = Constants.TIPO_NOT_NULL)
    @Size(max = Constants.TIPO_VALUE, message = Constants.TIPO_MAX_VALUE)
    @Pattern(regexp = Constants.SIMBOLS_REGEX, message = Constants.TIPO_REGEX)
    private String type;

    @NotBlank(message = Constants.BRAND_NOT_NULL)
    @Size(max = Constants.BRAND_VALUE, message = Constants.BRAND_MAX_VALUE)
    @Pattern(regexp = Constants.SIMBOLS_REGEX, message = Constants.BRAND_REGEX)
    private String brand;
    
    @NotBlank(message = Constants.COLOR_NOT_NULL)
    @Size(max = Constants.COLOR_VALUE, message = Constants.COLOR_MAX_VALUE)
    @Pattern(regexp = Constants.SIMBOLS_REGEX, message = Constants.COLOR_REGEX)
    private String color;

    @Size(max = Constants.NOTES_VALUE, message = Constants.NOTES_MAX_VALUE)
    @Pattern(regexp = Constants.SIMBOLS_REGEX, message = Constants.NOTES_REGEX)
    private String notes;

    public ProductDTO(Product product) {
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.type = product.getType();
        this.brand = product.getBrand();
        this.color = product.getColor();
        this.notes = product.getNotes();
    }
}
