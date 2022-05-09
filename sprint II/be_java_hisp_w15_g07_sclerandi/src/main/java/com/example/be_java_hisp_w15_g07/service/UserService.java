package com.example.be_java_hisp_w15_g07.service;

import com.example.be_java_hisp_w15_g07.dto.response.FollowedDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersDTO;
import com.example.be_java_hisp_w15_g07.dto.response.UserFollowersDTO;
import com.example.be_java_hisp_w15_g07.exception.BadRequestException;
import com.example.be_java_hisp_w15_g07.model.User;

import com.example.be_java_hisp_w15_g07.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    private IUserRepository userRepository;
    private ModelMapper modelMapper;

    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
        modelMapper = new ModelMapper();
    }

    /**
     * get followers list
     *
     * @param userId Integer
     * @return {@link FollowersDTO}
     * @see FollowersDTO
     */
    @Override
    public FollowersDTO getFollowersList(Integer userId) {
        User user = userRepository.findById(userId);
        FollowersDTO followers = modelMapper.map(user, FollowersDTO.class);
        List<UserFollowersDTO> userFollowers = user.getFollowers().stream()
                .map(v -> modelMapper.map(userRepository.findById(v.getUserId()), UserFollowersDTO.class))
                .collect(Collectors.toList());
        followers.setFollowers(userFollowers);
        return followers;
    }


    /**
     * get followers list
     *
     * @param userId Integer
     * @param order String
     * @return {@link FollowersDTO}
     * @see FollowersDTO
     * @author Tomas Ravelli
     * @author Jeronimo Graff
     */
    @Override
    public FollowersDTO getFollowersList(Integer userId, String order) {
        List<User> followers;
        if(!order.equals("name_asc") && !order.equals("name_desc")){
            throw new BadRequestException("Argumento de ordenamiento invalido");
        }
        else{
            if(order.equals("name_asc")){
                followers = userRepository.findFollowersOrderByNameAsc(userId);
            }
            else {
                followers = userRepository.findFollowersOrderByNameDesc(userId);
            }
        }
        FollowersDTO followersDTO = new FollowersDTO();
        followersDTO.setUserID(userId);
        followersDTO.setUserName(userRepository.findById(userId).getUserName());

        List<UserFollowersDTO> userFollowers = followers.stream()
                .map(v -> modelMapper.map(userRepository.findById(v.getUserId()), UserFollowersDTO.class))
                .collect(Collectors.toList());
        followersDTO.setFollowers(userFollowers);
        return followersDTO;
    }


    /**
     * get followed list ordered by user name
     *
     * @param userId Integer
     * @param order String
     * @return {@link FollowedDTO}
     * @see FollowedDTO
     * @author Tomas Ravelli
     * @author Jeronimo Graff
     */
    @Override
    public FollowedDTO getFollowedList(Integer userId, String order) {
        List<User> followed;
        if(!order.equals("name_asc") && !order.equals("name_desc")){
            throw new BadRequestException("Argumento de ordenamiento invalido");
        }
        else{
            if(order.equals("name_asc")){
                followed = userRepository.findFollowedOrderByNameAsc(userId);
            }
            else {
                followed = userRepository.findFollowedOrderByNameDesc(userId);
            }
        }
        FollowedDTO followedDTO = new FollowedDTO();
        followedDTO.setUserID(userId);
        followedDTO.setUserName(userRepository.findById(userId).getUserName());

        List<UserFollowersDTO> userFollowers = followed.stream()
                .map(v -> modelMapper.map(userRepository.findById(v.getUserId()), UserFollowersDTO.class))
                .collect(Collectors.toList());
        followedDTO.setFollowed(userFollowers);
        return followedDTO;
    }


    /**
     * get followed list
     *
     * @param userId Integer
     * @return {@link FollowedDTO}
     * @see FollowedDTO
     */
    @Override
    public FollowedDTO getFollowedList(Integer userId) {
        User user = userRepository.findById(userId);
        FollowedDTO followed = modelMapper.map(user, FollowedDTO.class);
        List<UserFollowersDTO> userFollowed = user.getFollowed().stream()
                .map(v -> modelMapper.map(userRepository.findById(v.getUserId()), UserFollowersDTO.class))
                .collect(Collectors.toList());
        followed.setFollowed(userFollowed);
        return followed;
    }


    /**
     * followers count by user
     *
     * @param idUser Integer
     * @return {@link FollowersCountDTO}
     * @see FollowersCountDTO
     * @author Jeronimo Graff
     * @author Facundo Chaves del Pino
     */
    public FollowersCountDTO followersCount(Integer idUser){
        User user = userRepository.findById(idUser);
        FollowersCountDTO followers = new FollowersCountDTO(user.getUserId(), user.getUserName(), user.getFollowers().size());
        return  followers;
    }


    /**
     * follow user
     *
     * @param userId Integer
     * @param userToFollowId Integer
     * @author Tomas Ravelli
     * @author Mauricio Gomez
     */
    @Override
    public void followUser(Integer userId, Integer userToFollowId) {
        User user = userRepository.findById(userId);
        User userToFollow = userRepository.findById(userToFollowId);

        if(userToFollow.getPosts().isEmpty()){
            throw new BadRequestException("No se puede seguir un usuario que no es vendedor.");
        }
        if(userId.equals(userToFollowId)){
            throw new BadRequestException("No se puede seguir a si mismo.");
        }
        if(!user.addUserToFollow(userToFollow)){
            throw new BadRequestException("Ya estas siguiendo a este usuario.");
        }
        if(!userToFollow.addFollower(user)){
            throw new BadRequestException("Ya estas seguido por este usuario.");
        }
    }


    /**
     * unfollow user
     *
     * @param userId Integer
     * @param userToUnfollowId Integer
     * @author Facundo Chaves del Pino
     */
    @Override
    public void unfollowUser(Integer userId, Integer userToUnfollowId) {
        User user = userRepository.findById(userId);
        User userToUnfollow = userRepository.findById(userToUnfollowId);

        if(userId.equals(userToUnfollowId)){
            throw new BadRequestException("No se puede dejar de seguir a si mismo.");
        }
        boolean unfollow = user.getFollowed().removeIf(u -> u.getUserId().equals(userToUnfollowId)) && userToUnfollow.getFollowers().removeIf(u -> u.getUserId().equals(userId));
        if (!unfollow){
            throw new BadRequestException("Este usuario no sigue a este vendedor.");
        }
    }
}
