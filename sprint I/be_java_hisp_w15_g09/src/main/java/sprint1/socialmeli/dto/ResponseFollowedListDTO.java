package sprint1.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResponseFollowedListDTO {

    private Integer userId;
    private String userName;
    private List<UserDTO> followers;

}
