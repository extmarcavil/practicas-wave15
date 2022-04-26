package sprint1.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseFollowersCountDTO {

    private Integer userId;
    private String userName;
    private Integer followersCount;



}
