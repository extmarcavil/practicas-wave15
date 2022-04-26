package sprint1.socialmeli.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sprint1.socialmeli.model.Product;

@Getter
@Setter
@NoArgsConstructor
public class PostRequestDTO {
    private Integer userId;
    private String date;
    private Product detail;
    private Integer category;
    private Double price;

    public PostRequestDTO(Integer userId, String date, Product detail, Integer category, Double price) {
        this.userId = userId;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

//    @Override
//    public String toString() {
//        return "PostRequestDTO{" +
//                "userId=" + userId +
//                ", date=" + date +
//                ", detail=" + detail +
//                ", category=" + category +
//                ", price=" + price +
//                '}';
//    }
}
