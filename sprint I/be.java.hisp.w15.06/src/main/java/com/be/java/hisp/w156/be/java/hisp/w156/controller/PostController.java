package com.be.java.hisp.w156.be.java.hisp.w156.controller;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.RecentlyPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPromoPostDTO;
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

    @PostMapping("promo-post")
    public ResponseEntity<SuccessDTO> createNewPromoPost(@RequestBody RequestPromoPostDTO requestPromoPostDTO){
       return ResponseEntity<>(productService)
    }

}
