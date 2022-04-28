package sprint1.socialmeli.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sprint1.socialmeli.model.User;

@Getter
@Setter
@AllArgsConstructor
public class FollowersCountDTO {

    private Integer userId;
    private String userName;
    private Integer followersCount;


    public FollowersCountDTO(User user1) {
        this.userId = user1.getId();
        this.userName = user1.getName();
        this.followersCount = user1.getListOfFollowers().size();
    }
}
