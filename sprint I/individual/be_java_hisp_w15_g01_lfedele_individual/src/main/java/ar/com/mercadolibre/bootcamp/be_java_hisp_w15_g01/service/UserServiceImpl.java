package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.*;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.FollowRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.PostRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.UserRepository;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Log
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
            log.warning("El id " + userId + " intento seguirse a si mismo");
            throw new OwnFollowingException("Your cant follow yourself");
        }
        User follower = this.findById(userId);
        User followed = this.findById(userIdToFollow);
        if(!this.postRepository.isseller(followed)) {
            log.warning("El id" + userId + " intento seguir a un no vendedor");
            throw new NotSellerException();
        }
        this.followRepository.save(follower, followed);

        ResponseDTO dto = new ResponseDTO();
        dto.setMessage("Followed!");
        return dto;
    }

    @Override
    public User findById(Long id) {
        User u = findByIdHARD(id);
        if (u.getDeactivated())
        {
            log.warning("Se busco una cuenta desactivada, id: " + id);
            throw new DeactivatedUserException();
        }
        return u;
    }

    private User findByIdHARD(Long id) {
        Optional<User> ou = userRepository.findById(id);
        if (ou.isPresent()) {
            return ou.get();
        } else {
            log.warning("Se busco un usuario inexistente, id " + id);
            throw new UserNotFoundException();
        }
    }

    @Override
    public FollowersListDTO whoFollowsMe(Long id, String order) {
        if (order != null && !order.equals("name_asc") && !order.equals("name_desc")){
            log.warning("Se recibieron parametros inesperados: " + order);
            throw new InvalidArgumentException("Invalid sorting Parameter. Must be name_desc or name_asc");
        }
        User user = this.findById(id);
        List<UserDTO> followers = this.followRepository
                .whoFollows(id)
                .stream()
                .filter(f -> !f.getFollower().getDeactivated())
                .map(f -> mapper.map(f.getFollower(), UserDTO.class))
                .sorted(Comparator.comparing(UserDTO::getUserName))
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
        Long followersCount = this.followRepository
                .whoFollows(userId)
                .stream().filter(f -> !f.getFollowing().getDeactivated())
                .count();

        FollowersCountDTO dto = new FollowersCountDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        dto.setFollowersCount(followersCount.intValue());
        return dto;
    }

    public FollowedListDTO findAllFollowedByUserId(Long userId, String order) {
        if (order != null && !order.equals("name_asc") && !order.equals("name_desc")){
            log.warning("Se recibieron parametros inesperados: " + order);
            throw new InvalidArgumentException("Invalid sorting Parameter. Must be name_desc or name_asc");
        }
        User userFollowing = findById(userId);
        List<UserDTO> followed = followRepository
                .findFollowedByUserId(userId)
                .stream()
                .filter(u -> !u.getDeactivated())
                .map(u -> mapper.map(u, UserDTO.class))
                .sorted(Comparator.comparing(UserDTO::getUserName))
                .collect(Collectors.toList());

        if (order!= null && order.equals("name_desc")){
            Collections.reverse(followed);
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
            log.warning("El usuario con id " + userId + " intento dejar de seguirse a si mismo");
            throw new OwnFollowingException("You can´t unfollow yourself");
        }
        User follower = this.findById(userId);
        User followed = this.findById(userIdToUnfollow);
        followRepository.unFollow(follower, followed);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Unfollowed");
        return responseDTO;
    }

    @Override
    public ResponseDTO deactivate(Long userId) {
        User user = this.findById(userId);
        user.deactivate();
        postRepository.desactivatePostsByUserId(userId);
        ResponseDTO dto = new ResponseDTO();
        dto.setMessage("Usuario desactivado!");
        return dto;
    }

    @Override
    public ResponseDTO activate(Long userId) {
        User user = this.findByIdHARD(userId);
        user.activate();
        postRepository.desactivatePostsByUserId(userId);
        ResponseDTO dto = new ResponseDTO();
        dto.setMessage("Usuario activado!");
        return dto;
    }
}
