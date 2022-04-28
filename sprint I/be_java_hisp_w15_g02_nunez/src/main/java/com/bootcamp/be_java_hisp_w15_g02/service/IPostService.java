package com.bootcamp.be_java_hisp_w15_g02.service;
import com.bootcamp.be_java_hisp_w15_g02.dto.request.DiscountedPostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.DiscountedProductsBySellerDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.DiscountedProductsListDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsSellerByUserIdDTO;

public interface IPostService {
    boolean createPost(PostCreateDTO newPost);
    boolean createPost(DiscountedPostCreateDTO newPost);
    GetPostsSellerByUserIdDTO getListPostByFollowIdUser(int idUser, String order);

    DiscountedProductsBySellerDTO getCountDiscountedProducts(int userId);

    DiscountedProductsListDTO findDiscountedProductsBySeller(int userId);
}

