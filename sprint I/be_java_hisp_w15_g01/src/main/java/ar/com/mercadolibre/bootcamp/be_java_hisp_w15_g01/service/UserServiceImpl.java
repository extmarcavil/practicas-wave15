package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowersCountDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowersListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.UserDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.NotFollowedException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.OwnFollowingException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.UserNotFoundException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.FollowRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService {
    private final UserRepository userRepository;
    private final FollowRepository followRepository;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepository, FollowRepository followRepository) {
        this.userRepository = userRepository;
        this.followRepository = followRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public ResponseDTO follow(Long userId, long userIdToFollow) {
        if (userId.equals(userIdToFollow)) {
            throw new OwnFollowingException();
        }
        User follower = this.findById(userId);
        User followed = this.findById(userIdToFollow);
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
    public FollowersListDTO whoFollowsMe(Long id) {
        User user = this.findById(id);
        List<UserDTO> followers = this.followRepository
                .whoFollows(id)
                .stream()
                .map(f -> mapper.map(f.getFollower(), UserDTO.class))
                .collect(Collectors.toList());

        FollowersListDTO dto = new FollowersListDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        dto.setUsers(followers);
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

    public FollowersListDTO findAllFollowedByUserId(Long userId) {
        List<UserDTO> followed = followRepository
                .findFollowedByUserId(userId)
                .stream()
                .map(u -> mapper.map(u, UserDTO.class))
                .collect(Collectors.toList());
        User userFollowing = findById(userId);

        if(followed.isEmpty()){
            throw new NotFollowedException();
        }
        FollowersListDTO userDto = new FollowersListDTO();
        userDto.setUserName(userFollowing.getUserName());
        userDto.setUserId(userId);
        userDto.setUsers(followed);
        return userDto;
    }
}
