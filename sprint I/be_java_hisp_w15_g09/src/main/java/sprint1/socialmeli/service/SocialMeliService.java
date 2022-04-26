package sprint1.socialmeli.service;

import org.springframework.stereotype.Service;
import sprint1.socialmeli.exceptions.UserNotFound;
import sprint1.socialmeli.model.User;
import sprint1.socialmeli.repository.ISocialMeliRepository;

@Service
public class SocialMeliService implements ISocialMeliService {

    ISocialMeliRepository repository;

    public SocialMeliService(ISocialMeliRepository repository) {
        this.repository = repository;
    }

    @Override
    public void follow(Integer userID, Integer userIdToFollow) {

        if( this.repository.existUser(userID) == false ){
            throw new UserNotFound("Usuario seguidor con id: "+ userID + " no fue encontrado");
        }

        if (this.repository.existUser(userIdToFollow) == false){
            throw new UserNotFound("Usuario a seguir con id: "+ userIdToFollow + " no fue encontrado");
        }

        User followerUser = this.repository.getUserByID(userID);
        User followedUser = this.repository.getUserByID(userIdToFollow);
        followerUser.follow(followedUser);
    }
}
