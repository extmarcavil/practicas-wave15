package com.be.java.hisp.w156.be.java.hisp.w156.vitale.controller;

import com.be.java.hisp.w156.be.java.hisp.w156.vitale.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.vitale.dto.request.RequestPromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.vitale.dto.response.PromoPostsCountDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.vitale.dto.response.PromoPostsListDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.vitale.dto.response.RecentlyPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.vitale.dto.response.SuccessDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.vitale.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    private final IProductService productService;

    @Autowired
    public PostController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("post")
    public ResponseEntity<SuccessDTO> createPost(@RequestBody RequestPostDTO requestPostDTO) {
        return productService.savePost(requestPostDTO);
    }

    @GetMapping("followed/{userId}/list")
    public ResponseEntity<RecentlyPostDTO> getPostsLastTwoWeekById(@PathVariable Integer userId,
                                                                   @RequestParam(required=false, defaultValue = "") String order) {
        return productService.getPostsLastTwoWeekById(userId, order);

    }

    @PostMapping("promo-post")
    public ResponseEntity<SuccessDTO> createPromoPost(@RequestBody RequestPromoPostDTO requestPromoPostDTO) {
        return productService.savePromoPost(requestPromoPostDTO);
    }


    @GetMapping("promo-post/count")
    public ResponseEntity<PromoPostsCountDTO> getPromoPostsCount(@RequestParam(required = true) Integer user_id) {
        return productService.getPromoPostsCount(user_id);
    }


    @GetMapping("promo-post/list")
    public ResponseEntity<PromoPostsListDTO> getPromoPostsList(@RequestParam(required = true) Integer user_id) {
        return productService.getPromoPostsList(user_id);
    }

}
