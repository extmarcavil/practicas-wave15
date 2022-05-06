package sprint2.socialmeli.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sprint2.socialmeli.model.User;
import sprint2.socialmeli.utils.UserConverter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResponseFollowersListDTO {

    private Integer userId;
    private String userName;
    private List<UserDTO> followers;

    public ResponseFollowersListDTO(User anUser, List<User> orderListOfFollowers) {
        UserConverter aConverter = new UserConverter();
        this.userId = anUser.getId();
        this.userName = anUser.getName();
        this.followers = aConverter.createFromEntities(orderListOfFollowers);
    }
}
