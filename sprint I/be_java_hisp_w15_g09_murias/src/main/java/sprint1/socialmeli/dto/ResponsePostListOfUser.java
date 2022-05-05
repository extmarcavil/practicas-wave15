package sprint1.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResponsePostListOfUser {
    private Integer userId;
    private String userName;
    private List<PostResponseDTO> posts;
}
