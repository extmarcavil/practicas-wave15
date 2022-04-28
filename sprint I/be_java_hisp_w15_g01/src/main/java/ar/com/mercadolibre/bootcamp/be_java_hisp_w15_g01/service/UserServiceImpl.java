package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.*;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
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

    /**
     * UserService
     * Accion de seguir a un vendedor
     *
     * @param userId El usuario que quiere seguir a otro usuario
     * @param userIdToFollow El usuario target al cual quieren seguir
     */
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

    /**
     * UserService
     * Busca un usuario por id
     *
     * @param id El id del usuario a buscar
     */
    @Override
    public User findById(Long id) {
        Optional<User> ou = userRepository.findById(id);
        if (ou.isPresent()) {
            return ou.get();
        } else {
            throw new UserNotFoundException();
        }
    }

    /**
     * UserService
     * Devuelve la lista de quienes siguen a userId
     *
     * @param id El usuario a buscar
     * @param order El orden de los parametros
     */
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

    /**
     * UserService
     * Devuelve la cuenta de cuantas personas siguen a userId
     *
     * @param userId El usuario a buscar
     */
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

    /**
     * UserService
     * Devuelve la la lista de todas las personas a las que sigue userId
     *
     * @param userId El usuario a buscar
     */
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

    /**
     * UserController
     * Accion de dejar de seguir a un vendedor
     *
     * @param userId El usuario que quiere dejar de seguir a otro usuario
     * @param userIdToUnfollow El usuario target al cual quieren dejar de seguir
     */
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

    /**
     * UserController
     * Obtiene una lista de todos los usuarios
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
