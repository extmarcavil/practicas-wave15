package sprint1.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.model.User;

@Getter
@Setter
@AllArgsConstructor
public class ResponsePromoPostCountDTO {

    private int userId;
    private String userName;
    private Integer promoPostCount;


}
