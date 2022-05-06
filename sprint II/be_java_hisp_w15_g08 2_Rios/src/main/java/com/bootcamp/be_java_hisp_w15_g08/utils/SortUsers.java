package com.bootcamp.be_java_hisp_w15_g08.utils;

import com.bootcamp.be_java_hisp_w15_g08.dto.response.PostNotUserIdDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.UserDTO;

import java.util.Comparator;
import java.util.List;

public class SortUsers {

    public static List<UserDTO> order (List<UserDTO> list, String order){
        if(order.equalsIgnoreCase("name_asc")){
             list.sort(Comparator.comparing(UserDTO::getName));
        } else if (order.equalsIgnoreCase("name_desc")){
            list.sort(Comparator.comparing(UserDTO::getName).reversed());
        }
        return list;
    }

    public static List<PostNotUserIdDTO> orderDate (List<PostNotUserIdDTO> list, String order){
        if(order.equalsIgnoreCase("date_asc")){
            list.sort(Comparator.comparing(PostNotUserIdDTO::getDate));
        } else if (order.equalsIgnoreCase("date_desc")){
            list.sort(Comparator.comparing(PostNotUserIdDTO::getDate).reversed());
        }
        return list;
    }
}
