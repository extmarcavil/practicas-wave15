package sprint1.socialmeli.dtos.Responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostListDTO {
    private Integer userId;
    private List<PostResponseDTO> posts;
}
