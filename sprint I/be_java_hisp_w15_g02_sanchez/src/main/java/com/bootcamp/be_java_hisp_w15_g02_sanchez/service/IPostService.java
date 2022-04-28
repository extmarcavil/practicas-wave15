package com.bootcamp.be_java_hisp_w15_g02_sanchez.service;
import com.bootcamp.be_java_hisp_w15_g02_sanchez.dto.request.PostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02_sanchez.dto.response.GetPostsSellerByUserIdDTO;
import com.bootcamp.be_java_hisp_w15_g02_sanchez.dto.response.GetProductsCountPromoByUserDTO;
import com.bootcamp.be_java_hisp_w15_g02_sanchez.dto.response.GetProductsPromoByUserDTO;

public interface IPostService {
    boolean createPost(PostCreateDTO newPost);
    GetPostsSellerByUserIdDTO getListPostByFollowIdUser(int idUser, String order);
    GetProductsCountPromoByUserDTO getProductsCountPromoByUser(int userId);
    GetProductsPromoByUserDTO getProductsPromoByUser(int userId,String order);
}

