package sprint1.socialmeli.dto.post.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResponsePostListDTO {
    private Integer userId;
    private List<ResponsePostDTO> posts;
}
