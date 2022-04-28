package sprint1.socialmeli.dto.post.request;

import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.model.Product;

@Setter
@Getter
public class RequestPromoPostDTO extends RequestPostDTO {
    boolean hasPromo;
    int discount;

    public RequestPromoPostDTO(Integer userId, String date, Product detail, Integer category, Double price, boolean hasPromo, int discount) {
        super(userId, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    @Override
    public boolean isAPromoPost() {
        return true;
    }
}
