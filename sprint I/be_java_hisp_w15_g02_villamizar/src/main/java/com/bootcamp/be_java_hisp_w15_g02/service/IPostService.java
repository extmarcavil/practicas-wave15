package com.bootcamp.be_java_hisp_w15_g02.service;
import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsCountDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsDTO;

public interface IPostService {
    boolean createPost(PostCreateDTO newPost);
    GetPostsDTO getListPostByFollowIdUser(int idUser, String order);
    GetPostsDTO getListPromoPostByIdUser(int idUser);
    GetPostsCountDTO getPromoCountByIdUser(int idUser);

}

