package com.bootcamp.be_java_hisp_w15_g02.service;
import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.request.PromoPostDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsSellerByUserIdDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPromoPostBySellerDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPromoPostCountDTO;
import com.bootcamp.be_java_hisp_w15_g02.model.Post;

public interface IPostService {
    boolean createPost(PostCreateDTO newPost);
    boolean createPromoPost(PromoPostDTO newPost);
    GetPostsSellerByUserIdDTO getListPostByFollowIdUser(int idUser, String order);
    GetPromoPostCountDTO getPromoPostCount(int userId);
    GetPromoPostBySellerDTO getPromoPostById(int idUser);
}

