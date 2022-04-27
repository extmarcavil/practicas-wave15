package sprint1.socialmeli.dto;

import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.model.Product;

@Setter
@Getter
public class NormalPostRequestDTO extends PostRequestDTO{

    public NormalPostRequestDTO(Integer userId, String date, Product detail, Integer category, Double price) {
        super(userId, date, detail, category, price);
    }

    @Override
    public boolean isAPromoPost() {
        return false;
    }
}
