package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.*;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.FollowRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.PostRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final FollowRepository followRepository;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepository, PostRepository postRepository, FollowRepository followRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.followRepository = followRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public ResponseDTO follow(Long userId, long userIdToFollow) {
        if (userId.equals(userIdToFollow)) {
            throw new OwnFollowingException("Your cant follow yourself");
        }
        User follower = this.findById(userId);
        User followed = this.findById(userIdToFollow);
        if(!this.postRepository.isseller(followed)) {
            throw new NotSellerException();
        }
        this.followRepository.save(follower, followed);

        ResponseDTO dto = new ResponseDTO();
        dto.setMessage("Followed!");
        return dto;
    }

    @Override
    public User findById(Long id) {
        Optional<User> ou = userRepository.findById(id);
        if (ou.isPresent()) {
            return ou.get();
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public FollowersListDTO whoFollowsMe(Long id, String order) {
        if (order != null && !order.equals("name_asc") && !order.equals("name_desc")){
            throw new InvalidArgumentException("Invalid sorting Parameter. Must be name_desc or name_asc");
        }
        User user = this.findById(id);
        List<UserDTO> followers = this.followRepository
                .whoFollows(id)
                .stream()
                .map(f -> mapper.map(f.getFollower(), UserDTO.class))
                .sorted((v,k)->v.getUserName().compareTo(k.getUserName()))
                .collect(Collectors.toList());

        if (order!= null && order.equals("name_desc")){
            Collections.reverse(followers);
        }

        FollowersListDTO dto = new FollowersListDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        dto.setFollowers(followers);
        return dto;
    }

    @Override
    public FollowersCountDTO wowManyFollowsMe(Long userId) {
        User user = this.findById(userId);
        Integer followersCount = this.followRepository
                .whoFollows(userId)
                .size();

        FollowersCountDTO dto = new FollowersCountDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        dto.setFollowersCount(followersCount);
        return dto;
    }

    public FollowedListDTO findAllFollowedByUserId(Long userId, String order) {
        if (order != null && !order.equals("name_asc") && !order.equals("name_desc")){
            throw new InvalidArgumentException("Invalid sorting Parameter. Must be name_desc or name_asc");
        }
        List<UserDTO> followed = followRepository
                .findFollowedByUserId(userId)
                .stream()
                .map(u -> mapper.map(u, UserDTO.class))
                .sorted((v,k)->v.getUserName().compareTo(k.getUserName()))
                .collect(Collectors.toList());
        User userFollowing = findById(userId);

        if (order!= null && order.equals("name_desc")){
            Collections.reverse(followed);
        }

        if(followed.isEmpty()){
            throw new NotFollowedException("The user don't follow anyone");
        }
        FollowedListDTO userDto = new FollowedListDTO();
        userDto.setUserName(userFollowing.getUserName());
        userDto.setUserId(userId);
        userDto.setFollowed(followed);
        return userDto;
    }

    @Override
    public ResponseDTO unFollow(Long userId, long userIdToUnfollow) {
        if (userId.equals(userIdToUnfollow)) {
            throw new OwnFollowingException("You can´t unfollow yourself");
        }
        User follower = this.findById(userId);
        User followed = this.findById(userIdToUnfollow);
        followRepository.unFollow(follower, followed);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Unfollowed");
        return responseDTO;
    }
}
