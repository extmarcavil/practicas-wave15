package com.bootcamp.be_java_hisp_w15_g02.service;

import com.bootcamp.be_java_hisp_w15_g02.dto.UserCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowedByUserDTO;
import com.bootcamp.be_java_hisp_w15_g02.exception.FollowUnfollowErrorsException;
import com.bootcamp.be_java_hisp_w15_g02.exception.NotSellerException;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g02.exception.OrderNotFoundException;
import com.bootcamp.be_java_hisp_w15_g02.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w15_g02.model.Follow;
import com.bootcamp.be_java_hisp_w15_g02.model.User;
import com.bootcamp.be_java_hisp_w15_g02.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersBySellerDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.FollowersDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
* UserService.java
* This class handles the user services
* @author grupo2
 */
@Service
public class UserService implements IUserService {
    private IUserRepository userRepository;
    /**
     * Injects Repository dependency in constructor
     * @param userRepository The repository to be injected
     */
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public boolean createUser() {
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        return false;
    }

    /**
     * This method allows a user to follow another user
     * @param userId Id of the user to follow
     * @param userIdToFollow Id of the user to be followed
     * @exception NotSellerException User is not a seller
     */
    @Override
    public void follow(int userId, int userIdToFollow) {
        if (userId == userIdToFollow)
            throw new FollowUnfollowErrorsException("No puede seguirse así mismo.");
        if (!userRepository.follow(userId, userIdToFollow))
            throw new NotSellerException("Error en seguir usuario");
    }

    /**
     * This method allows a user to unfollow another user
     * @param userId Id of the user to unfollow
     * @param userIdToFollow Id of the user to be unfollowed
     * @throws NotSellerException User is not a seller
     */
    @Override
    public void unFollow(int userId, int userIdToFollow) {
        if (!userRepository.unFollow(userId, userIdToFollow))
            throw new NotSellerException("El usuario que intentas dejar de seguir no es un vendedor.");
    }

    /**
     * This method retrieves the follower count of a user
     * @param userId Id of the user whose user count is to be retrieved
     * @return DTO of the follower count of the user
     */
    public GetFollowersCountDTO getFollowersCount(int userId) {
        User user = userRepository.getUserById(userId);
        GetFollowersCountDTO response = new GetFollowersCountDTO(user.getUserId(),
                user.getUserName(),
                user.getFollowerList().size());

        return response;
    }

    /**
     * This method retrieves the users that a given user follows
     * @param userId Id of the user whose followees are to be retrieved
     * @param order The order by which the followees are to be retrieved
     *              (name_asc = ascending order, name_desc = descending order)
     * @throws OrderNotFoundException The order provided is not valid
     * @return DTO of the list of the users being followed by the given user
     */
    @Override
    public GetFollowedByUserDTO getFollowedByUser(int userId, String order) {
        User user = userRepository.getUserById(userId);
        List<FollowersDTO> listFollowed = mapFollowDTO(user.getFollowList());
        if (order != null) {
            if (order.equals("name_asc"))
                listFollowed.sort(Comparator.comparing(FollowersDTO::getUserName));
            else if (order.equals("name_desc"))
                listFollowed.sort(Comparator.comparing(FollowersDTO::getUserName, Comparator.reverseOrder()));
            else
                throw new OrderNotFoundException("Orden no encontrado");
        }
        GetFollowedByUserDTO responseFollowedUser = new GetFollowedByUserDTO(user.getUserId(), user.getUserName(), (List) listFollowed);
        return responseFollowedUser;
    }

    /**
     * This method retrieves the users that follow a given user
     * @param userId Id of the user whose followers are to be retrieved
     * @param order The order by which the followers are to be retrieved
     *              (name_asc = ascending order, name_desc = descending order)
     * @throws OrderNotFoundException The order provided is not valid
     * @return DTO of the list of the followers of the given user
     */
    @Override
    public GetFollowersBySellerDTO getFollowersBySeller(int userId, String order) {
        var result = new GetFollowersBySellerDTO();
        var user = userRepository.getUserById(userId);
        var listFollowers = new ArrayList<FollowersDTO>();

        if (user.isSeller()) {
            listFollowers = (ArrayList<FollowersDTO>) mapFollowDTO(user.getFollowerList());

            if (order != null) {

                if (order.equals("name_asc"))
                    listFollowers.sort(Comparator.comparing(FollowersDTO::getUserName));
                else if (order.equals("name_desc"))
                    listFollowers.sort(Comparator.comparing(FollowersDTO::getUserName, Comparator.reverseOrder()));
                else
                    throw new OrderNotFoundException("Orden no encontrado");
            }
            result.setUserId(user.getUserId());
            result.setUserName(user.getUserName());
            result.setFollowers((List) listFollowers);
        } else {
            throw new NotSellerException("Este usuario no es vendedor");
        }

        return result;
    }

    /**
     * This method maps a List<Follow> to a List<GetFollowersDTO>
     * @param listFollows List of followers
     * @return List of Followers DTO
     */
    public List<FollowersDTO> mapFollowDTO(List<Follow> listFollows){
        List<FollowersDTO> followsDto = new ArrayList<>();

        if (listFollows != null) {
            listFollows.forEach(item -> {
                var newDto = new FollowersDTO();
                newDto.setUserId(item.getUserToFollow());
                newDto.setUserName(userRepository.getListUser().stream()
                                                                    .filter(u -> u.getUserId() == item.getUserToFollow())
                                                                    .findFirst()
                                                                    .orElseThrow(UserNotFoundException::new).getUserName());
                followsDto.add(newDto);
            });
        }

        return  followsDto;
    }

}
