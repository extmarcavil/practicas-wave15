package sprint1.socialmeli.service;

import org.springframework.stereotype.Service;
import sprint1.socialmeli.dto.*;
import sprint1.socialmeli.exceptions.InvalidParamsException;
import sprint1.socialmeli.exceptions.UserNotFound;
import sprint1.socialmeli.model.User;
import sprint1.socialmeli.repository.ISocialMeliRepository;

import java.util.Comparator;
import java.util.List;

@Service
public class SocialMeliService implements ISocialMeliService {

    ISocialMeliRepository repository;
    UserConverter userConverter;

    public SocialMeliService(ISocialMeliRepository repository, UserConverter converter) {
        this.repository = repository;
        this.userConverter = converter;
    }

    @Override
    public void follow(Integer userID, Integer userIdToFollow) {
        existUser(userID, "Usuario seguidor con id:");
        existUser(userIdToFollow, "Usuario a seguir con id");

        User followerUser = getUserFromRepositoryById(userID);
        User followedUser = getUserFromRepositoryById(userIdToFollow);
        followerUser.follow(followedUser);
    }

    private User getUserFromRepositoryById(Integer userID) {
        return this.repository.findUserById(userID);
    }

    @Override
    public void unfollow(int userID, int userIdToUnfollow) {
        existUser(userID, "Usuario seguidor con id:");
        existUser(userIdToUnfollow, "Usuario seguido con id:");

        User followerUser = getUserFromRepositoryById(userID);
        User followedUser = getUserFromRepositoryById(userIdToUnfollow);
        followerUser.unfollow(followedUser);
    }

    @Override
    public ResponseFollowersCountDTO countFollowers(Integer userID) {
        existUser(userID, "Usuario con id:");
        User user1 = getUserFromRepositoryById(userID);
        return new ResponseFollowersCountDTO(user1);
    }

    @Override
    public ResponseFollowersListDTO listFollowers(Integer userId, String order) {
        existUser(userId, "Usuario con id:");
        User user = getUserFromRepositoryById(userId);

        if (order !=  null) {
            checkOrderParam(order);
            sortListOfUsers(user.getListOfFollowers(), order);
        }
        return new ResponseFollowersListDTO( user, userConverter.createFromEntities(user.getListOfFollowers()));
    }

    @Override
    public ResponseFollowedListDTO listFollowed(Integer userId, String order) {
        existUser(userId, "Usuario con id:");
        User user = getUserFromRepositoryById(userId);
        if (order !=  null) {
            checkOrderParam(order);
            sortListOfUsers(user.getListOfFollowed(), order);
        }
        return new ResponseFollowedListDTO( user, userConverter.createFromEntities(user.getListOfFollowed()) );
    }

    private static void checkOrderParam(String order) {
        if (!(order.equalsIgnoreCase("name_asc") || order.equalsIgnoreCase("name_desc"))) {
            throw new InvalidParamsException("Los parámetros ingresados son incorrectos. Este endpoint admite solo:\n" +
                    "order=name_asc\n" +
                    "order=name_desc");
        }
    }

    private void sortListOfUsers(List<User> users, String order) {

        users.sort(Comparator.comparing(User::getName));
        if (order.equals("name_desc")) {
            users.sort(Comparator.comparing(User::getName).reversed());
        }
    }

    private void existUser(Integer userId, String msg) {
        if( !this.repository.existUser(userId)){
            throw new UserNotFound(msg + " "+ userId + " no fue encontrado");
        }
    }
}
