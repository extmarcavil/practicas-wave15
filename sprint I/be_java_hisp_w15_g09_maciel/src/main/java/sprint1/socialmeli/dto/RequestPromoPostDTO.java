package sprint1.socialmeli.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sprint1.socialmeli.model.Product;

@Getter
@Setter
@NoArgsConstructor
public class RequestPromoPostDTO {

    private Integer userId;
    private String date;
    private Product detail;
    private Integer category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;

    public RequestPromoPostDTO(Integer userId, String date, Product detail, Integer category, Double price, Boolean hasPromo, Double discount) {
        this.userId = userId;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
