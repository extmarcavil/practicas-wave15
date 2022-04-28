package sprint1.socialmeli.dtos.Responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.model.User;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FollowersListDTO {

    private Integer userId;
    private String userName;
    private List<UserDTO> followers;

    public FollowersListDTO(User user, List<UserDTO> listOfDTO) {
        this.userId = user.getId();
        this.userName = user.getName();
        this.followers = listOfDTO;

    }
}
