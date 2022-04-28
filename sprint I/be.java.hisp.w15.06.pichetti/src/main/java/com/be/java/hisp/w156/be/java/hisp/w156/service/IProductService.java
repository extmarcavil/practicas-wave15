package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.PromoPostCountDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.RecentlyPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostPromoDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import org.springframework.http.ResponseEntity;

public interface IProductService {

    ResponseEntity<SuccessDTO> savePost(RequestPostDTO requestPostDto);
    ResponseEntity<SuccessDTO> savePostPromo(RequestPostPromoDTO requestPostPromoDto);

    ResponseEntity<RecentlyPostDTO> getPostsLastTwoWeekById(Integer id, String order);
    ResponseEntity<PromoPostCountDTO> getCountPostPromoByUser(Integer id);
}
