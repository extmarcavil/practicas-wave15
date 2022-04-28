package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.RecentlyPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.ResponseListPromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.ResponsePromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public interface IProductService extends Serializable {

    ResponseEntity<SuccessDTO> savePost(RequestPostDTO requestPostDto);
    ResponseEntity<SuccessDTO> savePromoPost(RequestPromoPostDTO requestPromoPostDTO);
    ResponseEntity<RecentlyPostDTO> getPostsLastTwoWeekById(Integer id, String order);
    ResponsePromoPostDTO getCountPromoPostByUser(Integer id);
    ResponseListPromoPostDTO getPromoPostByUser(Integer id, String order);

}
