package sprint1.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.model.User;

@Getter
@Setter
@AllArgsConstructor
public class ResponseCountPromoPostDTO {
    private Integer userId;
    private String userName;
    private Integer promoProductsCount;

    public ResponseCountPromoPostDTO(User user,Integer sum) {
        this.userId = user.getId();
        this.userName = user.getName();
        this.promoProductsCount = sum;
    }

}
