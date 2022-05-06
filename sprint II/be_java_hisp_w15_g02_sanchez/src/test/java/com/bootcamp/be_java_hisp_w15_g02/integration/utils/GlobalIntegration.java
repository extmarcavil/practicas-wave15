package com.bootcamp.be_java_hisp_w15_g02.integration.utils;

import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.request.ProductDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;
import java.util.List;

public class GlobalIntegration {
    public static String jsonFormat(Object objectSource) throws Exception{
        var objectWritter = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();

        return objectWritter.writeValueAsString(objectSource);
    }

    public static ProductDTO productDummy(){
        return new ProductDTO(100,"MacBook Pro","computer","Apple","gray","ram 16 GB");
    }

    public static PostCreateDTO postDummy(){
        return new PostCreateDTO(1, LocalDate.now(),productDummy(),"1",100);
    }

    public static PostCreateDTO postInvalidDummy(){
        var post = postDummy();
        post.setUser_id(100);
        return post;
    }

    public static GetFollowersCountDTO getFollowersCountDummy(){
        return new GetFollowersCountDTO(5,"Ramiro",3);
    }

    public static List<GetFollowersDTO> listFollowersBySellerDummy() throws Exception{
        var follow1 = new com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersDTO();
        follow1.setUserId(1);
        follow1.setUserName("Martin");
        var follow2 = new com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersDTO();
        follow2.setUserId(2);
        follow2.setUserName("Diana");
        var follow3 = new com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersDTO();
        follow3.setUserId(3);
        follow3.setUserName("Leo");
        List<GetFollowersDTO> listResult = List.of(follow1,follow2,follow3);
        return listResult;
    }

    public static List<GetFollowersDTO> listFollowedUserDummy() throws Exception{
        var follow1 = new com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersDTO();
        follow1.setUserId(4);
        follow1.setUserName("Carlos");
        var follow2 = new com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersDTO();
        follow2.setUserId(5);
        follow2.setUserName("Ramiro");
        List<GetFollowersDTO> listResult = List.of(follow1,follow2);
        return listResult;
    }
}
