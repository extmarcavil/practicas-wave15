package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.request.FollowRequestDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.request.UserIdDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.request.WhoAndHowManyFollowsMeRequestDTO;
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

@Service
@Log
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
    public ResponseDTO follow(FollowRequestDTO dto) {

        Long userId = dto.getUserId();
        Long userIdToFollow = dto.getUserIdToFollow();

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

        ResponseDTO dtoResponse = new ResponseDTO();
        dtoResponse.setMessage("Followed!");
        return dtoResponse;
    }

    @Override
    public User findById(Long id) {
        Optional<User> ou = userRepository.findById(id);
        if (ou.isPresent()) {
            return ou.get();
        } else {
            log.warning("Se busco un usuario inexistente, id " + id);
            throw new UserNotFoundException();
        }
    }

    @Override
    public FollowersListDTO whoFollowsMe(WhoAndHowManyFollowsMeRequestDTO dto) {
        Long id = dto.getUserId();
        String order = dto.getOrder();
        if (order != null && !order.equals("name_asc") && !order.equals("name_desc")){
            log.warning("Se recibieron parametros inesperados: " + order);
            throw new InvalidArgumentException("Invalid sorting Parameter. Must be name_desc or name_asc");
        }
        User user = this.findById(id);

        List<UserDTO> followers = this.followRepository
                .whoFollows(id)
                .stream()
                .map(f -> mapper.map(f.getFollower(), UserDTO.class))
                .sorted(Comparator.comparing(UserDTO::getUserName))
                .collect(Collectors.toList());

        if (order!= null && order.equals("name_desc")){
            Collections.reverse(followers);
        }

        FollowersListDTO dtoResponse = new FollowersListDTO();
        dtoResponse.setUserId(user.getUserId());
        dtoResponse.setUserName(user.getUserName());
        dtoResponse.setFollowers(followers);
        return dtoResponse;
    }

    @Override
    public FollowersCountDTO wowManyFollowsMe(UserIdDTO dto) {
        Long userId = dto.getUserId();
        User user = this.findById(userId);
        Integer followersCount = this.followRepository
                .whoFollows(userId)
                .size();

        FollowersCountDTO dtoResponse = new FollowersCountDTO();
        dtoResponse.setUserId(user.getUserId());
        dtoResponse.setUserName(user.getUserName());
        dtoResponse.setFollowersCount(followersCount);
        return dtoResponse;
    }

    public FollowedListDTO findAllFollowedByUserId(WhoAndHowManyFollowsMeRequestDTO dto) {

        Long userId = dto.getUserId();
        String order = dto.getOrder();
        if (order != null && !order.equals("name_asc") && !order.equals("name_desc")){
            log.warning("Se recibieron parametros inesperados: " + order);
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

        FollowedListDTO userDto = new FollowedListDTO();
        userDto.setUserName(userFollowing.getUserName());
        userDto.setUserId(userId);
        userDto.setFollowed(followed);
        return userDto;
    }

    @Override
    public ResponseDTO unFollow(FollowRequestDTO dto) {
        Long userId = dto.getUserId();
        Long userIdToUnfollow = dto.getUserIdToFollow();
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
}
