package sprint1.socialmeli.dtos.Requests;

import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.model.Product;

@Getter
@Setter
public class PromoPostRequestDTO {
    private Integer userId;
    private String date;
    private Product detail;
    private Integer category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;
}
