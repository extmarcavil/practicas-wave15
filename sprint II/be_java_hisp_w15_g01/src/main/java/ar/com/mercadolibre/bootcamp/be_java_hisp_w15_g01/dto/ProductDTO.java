package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotNull(message = "El  id no puede estar vacío.")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private Long productId;

    @NotNull(message = "El nombre no puede estar vacío.")
    @Size(max = 40, message = "El nombre no puede tener mas de 40 caracteres")
    // TODO: buscar reggepx
    private String productName;

    @NotNull(message = "El tipo no puede estar vacío.")
    @Size(max = 15, message = "El tipo no puede tener mas de 15 caracteres")
    // TODO: buscar reggepx
    private String type;

    @NotNull(message = "La marca no puede estar vacía.")
    @Size(max = 25, message = "El tipo no puede tener mas de 25 caracteres")
    // TODO: buscar reggepx
    private String brand;
    
    @NotNull(message = "El color no puede estar vacía.")
    @Size(max = 15, message = "El tipo no puede tener mas de 15 caracteres")
    // TODO: buscar reggepx
    private String color;

    @Size(max = 80, message = "El tipo no puede tener mas de 80 caracteres")
    // TODO: buscar reggepx
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
