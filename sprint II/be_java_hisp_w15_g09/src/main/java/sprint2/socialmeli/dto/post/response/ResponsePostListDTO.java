package sprint2.socialmeli.dto.post.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sprint2.socialmeli.model.Post;
import sprint2.socialmeli.utils.PostConverter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResponsePostListDTO {
    private Integer userId;
    private List<ResponsePostDTO> posts;

    public ResponsePostListDTO(Integer userId, List<Post> listOfPost) {
        PostConverter aPostConverter = new PostConverter();
        this.userId = userId;
        this.posts = aPostConverter.createFromEntities(listOfPost);
    }
}
