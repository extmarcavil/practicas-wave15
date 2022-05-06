package sprint2.socialmeli.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sprint2.socialmeli.model.User;

@Getter
@Setter
@AllArgsConstructor
public class ResponseFollowersCountDTO {

    private Integer userId;
    private String userName;
    private Integer followersCount;


    public ResponseFollowersCountDTO(User user1) {
        this.userId = user1.getId();
        this.userName = user1.getName();
        this.followersCount = user1.getListOfFollowers().size();
    }
}
