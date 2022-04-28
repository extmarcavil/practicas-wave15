package sprint1.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResponsePostPromoListDTO {
    private Integer userId;
    private String user_name;
    private int promo_products_count;
}
