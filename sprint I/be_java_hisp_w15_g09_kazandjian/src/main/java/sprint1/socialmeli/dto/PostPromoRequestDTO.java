package sprint1.socialmeli.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sprint1.socialmeli.model.Product;

@Getter @Setter @NoArgsConstructor
public class PostPromoRequestDTO {
    private Integer userId;
    private String date;
    private Product detail;
    private Integer category;
    private Double price;
    private boolean hasPromo;
    private Double discount;

}
