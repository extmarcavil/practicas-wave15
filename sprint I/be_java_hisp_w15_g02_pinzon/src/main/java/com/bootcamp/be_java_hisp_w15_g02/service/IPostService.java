package com.bootcamp.be_java_hisp_w15_g02.service;
import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreatePromoDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostCountDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostPromoSellerDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsSellerByUserIdDTO;

public interface IPostService {
    boolean createPost(PostCreateDTO newPost);
    boolean createPostPromo(PostCreatePromoDTO newPost);
    GetPostsSellerByUserIdDTO getListPostByFollowIdUser(int idUser, String order);
    GetPostCountDTO getPostCountUser(int userId);
    GetPostPromoSellerDTO getListPostPromoSeller(int userId);
}

