package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.CantPromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.ListPromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.RecentlyPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import org.springframework.http.ResponseEntity;

public interface IProductService {

    ResponseEntity<SuccessDTO> savePost(RequestPostDTO requestPostDto);

    ResponseEntity<RecentlyPostDTO> getPostsLastTwoWeekById(Integer id, String order);

    ResponseEntity<SuccessDTO> savePromoPost(RequestPromoPostDTO requestPromoPostDto);

    ResponseEntity<CantPromoPostDTO> getCantPromoPostsById(Integer id);

    ResponseEntity<ListPromoPostDTO> getPromoPostsById(Integer id, String order);
}
