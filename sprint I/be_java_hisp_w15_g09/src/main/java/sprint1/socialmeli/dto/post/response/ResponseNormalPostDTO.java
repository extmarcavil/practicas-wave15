package sprint1.socialmeli.dto.post.response;

import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.model.Post;

@Getter
@Setter
public class ResponseNormalPostDTO extends ResponsePostDTO{
    public ResponseNormalPostDTO(Post post) {
        super(post);
    }
}
