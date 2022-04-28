package sprint1.socialmeli.dto.Responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PromoPostCountDTO {
    private Integer userId;
    private String userName;
    private Integer promoProductsCount;
}
