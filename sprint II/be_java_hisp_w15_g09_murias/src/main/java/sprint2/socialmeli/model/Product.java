package sprint2.socialmeli.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sprint2.socialmeli.dto.ProductDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public Product(ProductDTO dto) {
        this.mapToDTO(dto);
    }

    public void mapToDTO(ProductDTO productDTO) {
        this.productId = productDTO.getProductId();
        this.productName = productDTO.getProductName();
        this.type = productDTO.getType();
        this.brand = productDTO.getBrand();
        this.color = productDTO.getColor();
        this.notes = productDTO.getNotes();
    }
}
