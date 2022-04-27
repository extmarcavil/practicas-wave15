package com.bootcamp.be_java_hisp_w15_g02.service;
import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsSellerByUserIdDTO;

public interface IPostService {
    boolean createPost(PostCreateDTO newPost);
    GetPostsSellerByUserIdDTO getListPostByFollowIdUser(int idUser);
}

