package com.bootcamp.be_java_hisp_w15_g02.service;

import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersCountDTO;
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
        var where = userRepository.getListUser()
                .stream()
                .filter(f -> f.getUserId() == userId).findFirst();

        var user = where.get();

        var listFollowers = new ArrayList<GetFollowersDTO>();

        var listIntFollowers = where.get().getFollowerList();
        if (listIntFollowers != null && user.isSeller()) {
            listIntFollowers.forEach(item -> {
                var newDto = new GetFollowersDTO();
                newDto.setUser_id(item.getUserToFollow());
                newDto.setUser_name(userRepository.getUserById(item.getUserToFollow()).getUserName());
                listFollowers.add(newDto);
            });
            result.setUser_id(user.getUserId());
            result.setUser_name(user.getUserName());
            result.setFollowers((List) listFollowers);
        }

        return result;
    }

}
