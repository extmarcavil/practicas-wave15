package com.bootcamp.be_java_hisp_w15_g02.service;

import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowedByUserDTO;
import com.bootcamp.be_java_hisp_w15_g02.exception.NotSellerException;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g02.exception.OrderNotFoundException;
import com.bootcamp.be_java_hisp_w15_g02.model.Follow;
import com.bootcamp.be_java_hisp_w15_g02.model.User;
import com.bootcamp.be_java_hisp_w15_g02.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersBySellerDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class UserService implements IUserService {
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void follow(int userId, int userIdToFollow) {
        if (!userRepository.follow(userId, userIdToFollow))
            throw new NotSellerException("Error en seguir usuario");
    }

    @Override
    public void unFollow(int userId, int userIdToFollow) {
        if (!userRepository.unFollow(userId, userIdToFollow))
            throw new NotSellerException("Error en dejar de seguir usuario");
    }

    public GetFollowersCountDTO getFollowersCount(int userId) {
        User user = userRepository.getUserById(userId);
        GetFollowersCountDTO response = new GetFollowersCountDTO(user.getUserId(),
                user.getUserName(),
                user.getFollowerList().size());

        return response;
    }

    @Override
    public GetFollowedByUserDTO getFollowedByUser(int userId, String order) {
        User user = userRepository.getUserById(userId);
        List<GetFollowersDTO> listFollowed = mapFollowDTO(user.getFollowList());
        if (order != null) {
            if (order.equals("name_asc"))
                listFollowed.sort(Comparator.comparing(GetFollowersDTO::getUserName));
            else if (order.equals("name_desc"))
                listFollowed.sort(Comparator.comparing(GetFollowersDTO::getUserName, Comparator.reverseOrder()));
            else
                throw new OrderNotFoundException("Orden no encontrado");
        }
        GetFollowedByUserDTO responseFollowedUser = new GetFollowedByUserDTO(user.getUserId(), user.getUserName(), (List) listFollowed);
        return responseFollowedUser;
    }

    @Override
    public GetFollowersBySellerDTO getFollowersBySeller(int userId, String order) {
        var result = new GetFollowersBySellerDTO();
        var user = userRepository.getUserById(userId);
        var listFollowers = new ArrayList<GetFollowersDTO>();

        if (user.isSeller()) {
            listFollowers = (ArrayList<GetFollowersDTO>) mapFollowDTO(user.getFollowerList());

            if (order != null) {

                if (order.equals("name_asc"))
                    listFollowers.sort(Comparator.comparing(GetFollowersDTO::getUserName));
                else if (order.equals("name_desc"))
                    listFollowers.sort(Comparator.comparing(GetFollowersDTO::getUserName, Comparator.reverseOrder()));
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

    private List<GetFollowersDTO> mapFollowDTO(List<Follow> listFollows){
        List<GetFollowersDTO> followsDto = new ArrayList<>();

        if (listFollows != null) {
            listFollows.forEach(item -> {
                var newDto = new GetFollowersDTO();
                newDto.setUserId(item.getUserToFollow());
                newDto.setUserName(userRepository.getUserById(item.getUserToFollow()).getUserName());
                followsDto.add(newDto);
            });
        }

        return  followsDto;
    }

}
