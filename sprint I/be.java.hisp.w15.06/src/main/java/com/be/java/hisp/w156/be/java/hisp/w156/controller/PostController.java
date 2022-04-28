package com.be.java.hisp.w156.be.java.hisp.w156.controller;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.RecentlyPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.ResponseListPromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.ResponsePromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    //US10
    @PostMapping("promo-post")
    public ResponseEntity<SuccessDTO> createNewPromoPost(@RequestBody RequestPromoPostDTO requestPromoPostDTO){
       return productService.savePromoPost(requestPromoPostDTO);
    }

    // US11
    @GetMapping("promo-post/count")
    public ResponseEntity<ResponsePromoPostDTO> getCountPromoPostByUser(@RequestParam Integer user_id){
        return new ResponseEntity<ResponsePromoPostDTO>(productService.getCountPromoPostByUser(user_id), HttpStatus.OK);
    }

    //US12
    @GetMapping("promo-post/list")
    public ResponseEntity<ResponseListPromoPostDTO> getPromoPostByUser(@RequestParam Integer user_id,
                                                                       @RequestParam(required = false) String order){
        return new ResponseEntity<ResponseListPromoPostDTO>(productService.getPromoPostByUser(user_id, order), HttpStatus.OK);
    }

}
