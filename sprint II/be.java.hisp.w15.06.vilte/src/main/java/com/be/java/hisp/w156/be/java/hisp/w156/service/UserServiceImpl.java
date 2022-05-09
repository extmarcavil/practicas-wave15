package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.*;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.InvalidOrderException;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.UserAlreadyFollowsTheUserException;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.UserCantFollowHimselfException;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.UserNotFollowedException;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;
import com.be.java.hisp.w156.be.java.hisp.w156.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<SuccessDTO> follow(Integer userId, Integer userToFollowId) {
        User user = userRepository.getUser(userId);
        User userToFollow = userRepository.getUser(userToFollowId);

        if(user == userToFollow)
            throw new UserCantFollowHimselfException();

        List<User> followed = user.getFollowed();

        if(followed.contains(userToFollow))
            throw new UserAlreadyFollowsTheUserException(userId, userToFollowId);

        followed.add(userToFollow);
        user.setFollowed(followed);

        List<User> followers = userToFollow.getFollowers();
        followers.add(user);
        userToFollow.setFollowers(followers);

        String message = String.format("The id user: %s had follow user %s", userId, userToFollowId);
        return new ResponseEntity<>(new SuccessDTO(message), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SuccessDTO> unfollow(Integer userId, Integer userToUnfollowId) {
        User user = userRepository.getUser(userId);
        User userToUnfollow = userRepository.getUser(userToUnfollowId);

        List<User> followed = user.getFollowed();
        if(!followed.contains(userToUnfollow))
            throw new UserNotFollowedException(userId, userToUnfollowId);

        followed.remove(userToUnfollow);
        user.setFollowed(followed);

        List<User> followers = userToUnfollow.getFollowers();
        followers.remove(user);
        userToUnfollow.setFollowers(followers);

        String message = String.format("The id user: %s had unfollow user %s", userId, userToUnfollow.getId());
        return new ResponseEntity<>(new SuccessDTO(message), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserCountFollowersDTO> getCountFollowers(Integer id) {
        User userSeller = this.userRepository.getUser(id);

        UserCountFollowersDTO  userCountFollowersDTO = new UserCountFollowersDTO(userSeller.getId(),
                userSeller.getName(),
                userSeller.getFollowers().size());

        return new ResponseEntity<>(userCountFollowersDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserFollowersDTO> getFollowers(Integer id, String order) {

        validateAlphabeticalOrdering(order);

        User userSeller = userRepository.getUser(id);
        List<UserDTO> followers = getUsersDtoFromAndSortedBy(userSeller.getFollowers(), order);
        UserFollowersDTO userFollowersDTO = new UserFollowersDTO(userSeller.getId(), userSeller.getName(), followers);

        return new ResponseEntity<>(userFollowersDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserFollowedDTO> getFollowed(Integer id, String order) {

        validateAlphabeticalOrdering(order);

        User user = userRepository.getUser(id);
        List<UserDTO> followed = getUsersDtoFromAndSortedBy(user.getFollowed(), order);
        UserFollowedDTO userFollowedDTO = new UserFollowedDTO(user.getId(), user.getName(), followed);

        return new ResponseEntity<>(userFollowedDTO, HttpStatus.OK);
    }

    private List<UserDTO> getUsersDtoFromAndSortedBy(List<User> users, String order) {
        return Optional.ofNullable(users)
                .orElseGet(Collections::emptyList)
                .stream()
                .map(UserDTO::from)
                .sorted(sortBy(order))
                .collect(Collectors.toList());
    }

    private Comparator<? super UserDTO> sortBy(String order) {
        return order.equals("name_asc")
                ? Comparator.comparing(UserDTO::getUser_name)
                : Comparator.comparing(UserDTO::getUser_name).reversed();
    }

    private void validateAlphabeticalOrdering(String order) {
        if (!(order.equals("name_asc") || order.equals("name_desc") || order.isEmpty()))
            throw new InvalidOrderException();
    }

}
