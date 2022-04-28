package com.be.java.hisp.w156.be.java.hisp.w156.controller;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.PostCountPromoDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.RecentlyPostPromoDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.RecentlyPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostPromoDTO;
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

    @PostMapping("/promo-post")
    public ResponseEntity<SuccessDTO> createPostPromotion(@RequestBody RequestPostPromoDTO requestPostPromoDTO) {
        return productService.savePostPromo(requestPostPromoDTO);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PostCountPromoDTO> getCountPromo(@RequestParam Integer user_id){
        PostCountPromoDTO postCountPromoDTO = productService.getCountPromotion(user_id);
        return new ResponseEntity<>(postCountPromoDTO, HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<RecentlyPostPromoDTO> getPostsPromotion(@RequestParam Integer user_id, @RequestParam(required=false, defaultValue = "") String order) {
        return productService.getPostsPromotion(user_id, order);
    }
}
