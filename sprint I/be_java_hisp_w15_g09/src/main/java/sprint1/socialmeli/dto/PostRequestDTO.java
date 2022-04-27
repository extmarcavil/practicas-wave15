package sprint1.socialmeli.dto;

import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.model.Product;

@Getter
@Setter
public abstract class PostRequestDTO {
    protected Integer userId;
    protected String date;
    protected Product detail;
    protected Integer category;
    protected Double price;

    public PostRequestDTO(Integer userId, String date, Product detail, Integer category, Double price) {
        this.userId = userId;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public abstract boolean isAPromoPost();
}
