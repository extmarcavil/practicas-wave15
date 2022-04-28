package sprint1.socialmeli.dto.post.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponsePromoPostListDTO {
    private Integer userId;
    private List<ResponsePromoPostDTO> posts;


    public ResponsePromoPostListDTO(Integer userId, List<ResponsePromoPostDTO> userPromoPost) {
        this.userId = userId;
        this.posts = userPromoPost;
    }
}
