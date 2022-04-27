package sprint1.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.model.User;

@Getter
@Setter
@AllArgsConstructor
public class ResponsePromoPostCountDTO {

    private Integer userId;
    private String userName;
    private Integer promo_products_count;


    public ResponsePromoPostCountDTO(User user,int count) {
        this.userId = user.getId();
        this.userName = user.getName();
        this.promo_products_count = count;
    }
}
