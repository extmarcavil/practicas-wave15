package sprint1.socialmeli.dtos.Responses;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PromoPostListDTO {
    private Integer userId;
    private String userName;
    private List<PromoPostResponseDTO> promoPosts;
}
