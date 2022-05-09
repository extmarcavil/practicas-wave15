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
public class ResponseFollowedListDTO {

    private Integer userId;
    private String userName;
    private List<UserDTO> followed;

    public ResponseFollowedListDTO(User user, List<User> orderListOfFollowed) {
        UserConverter aConverter = new UserConverter();
        this.userId = user.getId();
        this.userName = user.getName();
        this.followed = aConverter.createFromEntities(orderListOfFollowed);
    }
}
