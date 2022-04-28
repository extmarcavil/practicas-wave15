package com.be.java.hisp.w156.be.java.hisp.w156.vitale.service;

import com.be.java.hisp.w156.be.java.hisp.w156.vitale.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.vitale.dto.request.RequestPromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.vitale.dto.response.PromoPostsCountDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.vitale.dto.response.PromoPostsListDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.vitale.dto.response.RecentlyPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.vitale.dto.response.SuccessDTO;
import org.springframework.http.ResponseEntity;

public interface IProductService {

    ResponseEntity<SuccessDTO> savePost(RequestPostDTO requestPostDto);

    ResponseEntity<RecentlyPostDTO> getPostsLastTwoWeekById(Integer id, String order);

    ResponseEntity<SuccessDTO> savePromoPost(RequestPromoPostDTO requestPromoPostDto);

    ResponseEntity<PromoPostsCountDTO> getPromoPostsCount(Integer id);

    ResponseEntity<PromoPostsListDTO> getPromoPostsList(Integer id);
}
