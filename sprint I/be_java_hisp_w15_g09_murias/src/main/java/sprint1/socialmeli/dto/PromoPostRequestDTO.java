package sprint1.socialmeli.dto;

import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.model.Product;

@Getter
@Setter
public class PromoPostRequestDTO extends PostRequestDTO{

    private boolean hasPromo;
    private Double discount;


    public PromoPostRequestDTO(Integer userId, String date, Product detail, Integer category, Double price, boolean hasPromo, Double discount) {
        super(userId, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
