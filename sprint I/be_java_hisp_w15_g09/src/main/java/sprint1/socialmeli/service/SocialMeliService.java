package sprint1.socialmeli.service;

import org.springframework.stereotype.Service;
import sprint1.socialmeli.dto.ResponseFollowedListDTO;
import sprint1.socialmeli.dto.ResponseFollowersCountDTO;
import sprint1.socialmeli.dto.ResponseFollowersListDTO;
import sprint1.socialmeli.dto.UserDTO;
import sprint1.socialmeli.exceptions.InvalidParamsException;
import sprint1.socialmeli.exceptions.UserNotFound;
import sprint1.socialmeli.model.User;
import sprint1.socialmeli.repository.ISocialMeliRepository;

import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class SocialMeliService implements ISocialMeliService {

    ISocialMeliRepository repository;

    public SocialMeliService(ISocialMeliRepository repository) {
        this.repository = repository;
    }

    @Override
    public void follow(Integer userID, Integer userIdToFollow) {
        existUser(userID, "Usuario seguidor con id:");
        existUser(userIdToFollow, "Usuario a seguir con id");

        User followerUser = this.repository.findUserById(userID);
        User followedUser = this.repository.findUserById(userIdToFollow);
        // falta validar si pueden efectivamente hacer el follow en el usuario
        followerUser.follow(followedUser);
    }

    @Override
    public void unfollow(int userID, int userIdToUnfollow) {
        existUser(userID, "Usuario seguidor con id:");
        existUser(userIdToUnfollow, "Usuario seguido con id:");

        User followerUser = this.repository.findUserById(userID);
        User followedUser = this.repository.findUserById(userIdToUnfollow);
        // falta validar si pueden efectivamente hacer el unfollow en el usuario
        followerUser.unfollow(followedUser);
    }

    @Override
    public ResponseFollowersCountDTO countFollowers(Integer userID) {
        existUser(userID, "Usuario con id:");
        User user1 = repository.findUserById(userID);
        return new ResponseFollowersCountDTO(user1.getId(), user1.getName(), user1.getListOfFollowers().size());
    }

    @Override
    public ResponseFollowersListDTO listFollowers(Integer userId) {
        existUser(userId, "Usuario con id:");
        User user = repository.findUserById(userId);
        return new ResponseFollowersListDTO(user.getId(), user.getName(), user.getListOfFollowers()
                .stream()
                .map(ud -> new UserDTO(ud.getId(), ud.getName()))
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseFollowedListDTO listFollowed(Integer userId) {
        existUser(userId, "Usuario con id:");
        User user = repository.findUserById(userId);
        return new ResponseFollowedListDTO(user.getId(), user.getName(), user.getListOfFollowed()
                .stream()
                .map(ud -> new UserDTO(ud.getId(), ud.getName()))
                .collect(Collectors.toList()));
    }

    private static void checkOrderParam(String order) {
        if (!(order.equalsIgnoreCase("name_asc") || order.equalsIgnoreCase("name_desc"))) {
            throw new InvalidParamsException("Los parametros ingresados son incorrectos. Este endpoint admite solo:\n" +
                    "order=name_asc\n" +
                    "order=name_desc");
        }
    }

    @Override
    public ResponseFollowersListDTO sortedListFollowers(Integer userId, String order) {
        checkOrderParam(order);

        User user = repository.findUserById(userId);
        ResponseFollowersListDTO followersList = new ResponseFollowersListDTO(
                user.getId(),
                user.getName(),
                user.getListOfFollowers()
                        .stream()
                        .sorted(Comparator.comparing(User::getName))
                        .map(ud -> new UserDTO(ud.getId(), ud.getName()))
                        .collect(Collectors.toList()));

        if (order.equals("name_desc")) {
            followersList.getFollowers().sort(Comparator.comparing(UserDTO::getUserName).reversed());
        }
        return followersList;
    }

    @Override
    public ResponseFollowedListDTO sortedListFollowed(Integer userId, String order) {
        checkOrderParam(order);

        User user = repository.findUserById(userId);
        ResponseFollowedListDTO followedList = new ResponseFollowedListDTO(
                user.getId(),
                user.getName(),
                user.getListOfFollowed()
                        .stream()
                        .sorted(Comparator.comparing(User::getName))
                        .map(ud -> new UserDTO(ud.getId(), ud.getName()))
                        .collect(Collectors.toList()));

        if (order.equals("name_desc")) {
            followedList.getFollowers().sort(Comparator.comparing(UserDTO::getUserName).reversed());
        }
        return followedList;
    }

    private void existUser(Integer userId, String msg) {
        if( !this.repository.existUser(userId)){
            throw new UserNotFound(msg + " "+ userId + " no fue encontrado");
        }
    }
}
