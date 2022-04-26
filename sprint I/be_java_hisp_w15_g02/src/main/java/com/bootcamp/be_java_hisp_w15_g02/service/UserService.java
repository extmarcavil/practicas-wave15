package com.bootcamp.be_java_hisp_w15_g02.service;

import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowedByUserDTO;
import com.bootcamp.be_java_hisp_w15_g02.exception.NotSellerException;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g02.model.Follow;
import com.bootcamp.be_java_hisp_w15_g02.model.User;
import com.bootcamp.be_java_hisp_w15_g02.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersBySellerDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public GetFollowersCountDTO getFollowersCount(int userId) {
        User user = userRepository.getUserById(userId);
        GetFollowersCountDTO response = new GetFollowersCountDTO(user.getUserId(),
                user.getUserName(),
                user.getFollowerList().size());

        return response;
    }

    @Override
    public GetFollowersBySellerDTO getFollowersBySeller(int userId) {
        var result = new GetFollowersBySellerDTO();
        var user = userRepository.getUserById(userId);
        var listFollowers = new ArrayList<GetFollowersDTO>();

//        var listIntFollowers = user.getFollowerList();
//        if (user.isSeller()) {
//            listIntFollowers.forEach(item -> {
//                var newDto = new GetFollowersDTO();
//                newDto.setUser_id(item.getUserToFollow());
//                newDto.setUser_name(userRepository.getUserById(item.getUserToFollow()).getUserName());
//                listFollowers.add(newDto);
//            });
//            result.setUser_id(user.getUserId());
//            result.setUser_name(user.getUserName());
//            result.setFollowers((List) listFollowers);
//        }
        if (user.isSeller()) {
            listFollowers = (ArrayList<GetFollowersDTO>) mapFollowDTO(user.getFollowerList());
            result.setUser_id(user.getUserId());
            result.setUser_name(user.getUserName());
            result.setFollowers((List) listFollowers);
        }

        return result;
    }

    @Override
    public GetFollowedByUserDTO getFollowedByUser(int userId) {
        User user = userRepository.getUserById(userId);
        List<GetFollowersDTO> listFollowed = mapFollowDTO(user.getFollowList());
        GetFollowedByUserDTO responseFollowedUser = new GetFollowedByUserDTO(user.getUserId(), user.getUserName(), (List) listFollowed);
        return responseFollowedUser;
    }

    private List<GetFollowersDTO> mapFollowDTO(List<Follow> listFollows){
        List<GetFollowersDTO> followsDto = new ArrayList<>();

        if (listFollows != null) {
            listFollows.forEach(item -> {
                var newDto = new GetFollowersDTO();
                newDto.setUser_id(item.getUserToFollow());
                newDto.setUser_name(userRepository.getUserById(item.getUserToFollow()).getUserName());
                followsDto.add(newDto);
            });
        }

        return  followsDto;
    }

}
