package sprint1.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResponsePromoPostListDTO {

    private Integer userId;
    private List<ResponsePromoPostDTO> posts;
}
