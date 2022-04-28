package sprint1.socialmeli.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.model.User;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResponseFollowedListDTO {

    private Integer userId;
    private String userName;
    private List<UserDTO> followed;

    public ResponseFollowedListDTO(User user, List<UserDTO> listOfDTO) {
        this.userId = user.getId();
        this.userName = user.getName();
        this.followed = listOfDTO;
    }
}
