package com.bootcamp.be_java_hisp_w15_g02.unit.utils;

import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersDTO;
import com.bootcamp.be_java_hisp_w15_g02.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w15_g02.model.Follow;
import com.bootcamp.be_java_hisp_w15_g02.model.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Global {

    public static List<User> getListOfUsers(){
        List<User> listUser = new ArrayList<>();
        List<Follow> listFollowers = new ArrayList<>();
        List<Follow> listFollowers2 = new ArrayList<>();
        List<Follow> listFollows = new ArrayList<>();
        List<Follow> listFollows2 = new ArrayList<>();

        listFollows.add(new Follow(5));

        listFollows2.add(new Follow(5));

        listFollowers.add(new Follow(1));
        listFollowers.add(new Follow(3));

        listFollowers2.add(new Follow(1));
        listFollowers2.add(new Follow(2));
        listFollowers2.add(new Follow(3));

        User user4 = new User(4, "Carlos", new ArrayList<>(), listFollowers);
        User user5 = new User(5, "Ramiro", listFollows2, listFollowers2);
        user4.setSeller(true);
        user5.setSeller(true);
        listUser.add(new User(1, "Martin", listFollows, new ArrayList<>()));
        listUser.add(new User(2, "Leo", listFollows2, new ArrayList<>()));
        listUser.add(new User(3, "Diana", listFollows, new ArrayList<>()));
        listUser.add(user4);
        listUser.add(user5);

        return listUser;
    }

    public static User getUserByIdUtils(int userId){
        return getListOfUsers().stream().
                filter(f -> f.getUserId() == userId)
                .findFirst().orElseThrow(UserNotFoundException::new);
    }

    public static List<GetFollowersDTO> getListSorted(String order){
        List<GetFollowersDTO> followsDto = new ArrayList<>();
        User user = getUserByIdUtils(5);
        List<Follow> listFollows = user.getFollowerList();

        listFollows.forEach(item -> {
            var newDto = new GetFollowersDTO();
            newDto.setUserId(item.getUserToFollow());
            newDto.setUserName(getUserByIdUtils(item.getUserToFollow()).getUserName());
            followsDto.add(newDto);
        });

        return followsDto;
    }

    public void test(){
        String order = "";
        GetFollowersDTO listFollow1 = new GetFollowersDTO();
        listFollow1.setUserId(1);
        listFollow1.setUserName("Martin");

        GetFollowersDTO listFollow2 = new GetFollowersDTO();
        listFollow2.setUserId(2);
        listFollow2.setUserName("Leo");

        GetFollowersDTO listFollow3 = new GetFollowersDTO();
        listFollow3.setUserId(3);
        listFollow3.setUserName("Diana");

        List<GetFollowersDTO> listFollowDTO = new ArrayList<>();
        listFollowDTO.add(listFollow1);
        listFollowDTO.add(listFollow2);
        listFollowDTO.add(listFollow3);

        if (order.equals("name_asc"))
            listFollowDTO.sort(Comparator.comparing(GetFollowersDTO::getUserName));
        else if (order.equals("name_desc"))
            listFollowDTO.sort(Comparator.comparing(GetFollowersDTO::getUserName, Comparator.reverseOrder()));

    }
}
