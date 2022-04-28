package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.PostCountPromoDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.RecentlyPostPromoDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.RecentlyPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostPromoDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import org.springframework.http.ResponseEntity;

public interface IProductService {

    ResponseEntity<SuccessDTO> savePost(RequestPostDTO requestPostDto);

    ResponseEntity<RecentlyPostDTO> getPostsLastTwoWeekById(Integer id, String order);

    ResponseEntity<SuccessDTO> savePostPromo(RequestPostPromoDTO requestPostPromoDto);

    PostCountPromoDTO getCountPromotion(Integer userId);

    ResponseEntity<RecentlyPostPromoDTO> getPostsPromotion(Integer id, String order);
}
