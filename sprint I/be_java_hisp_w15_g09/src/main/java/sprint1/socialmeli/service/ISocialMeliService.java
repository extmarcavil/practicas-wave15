package sprint1.socialmeli.service;

import sprint1.socialmeli.dto.ResponseFollowedListDTO;
import sprint1.socialmeli.dto.ResponseFollowersCountDTO;
import sprint1.socialmeli.dto.ResponseFollowersListDTO;

public interface ISocialMeliService {
    void follow(Integer userID, Integer userIdToFollow);
    void unfollow(int userID, int userIdToUnfollow);

    public ResponseFollowersCountDTO countFollowers(Integer userID);

    public ResponseFollowersListDTO listFollowers(Integer userId, String order);

    public ResponseFollowedListDTO listFollowed(Integer userId, String order);
}
