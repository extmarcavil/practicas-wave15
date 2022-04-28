package com.bootcamp.be_java_hisp_w15_g02.service;
import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsSellerByUserIdDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetProductsCountPromoByUserDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetProductsPromoByUserDTO;

import java.util.List;

public interface IPostService {
    boolean createPost(PostCreateDTO newPost);
    GetPostsSellerByUserIdDTO getListPostByFollowIdUser(int idUser, String order);
    GetProductsCountPromoByUserDTO getProductsCountPromoByUser(int userId);
    GetProductsPromoByUserDTO getProductsPromoByUser(int userId,String order);
}

