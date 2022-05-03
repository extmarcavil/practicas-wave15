package com.be.java.hisp.w156.be.java.hisp.w156.controller;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.PostPromoCountDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.PostPromoDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.RecentlyPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostPromoDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.service.IProductService;
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
    public ResponseEntity<RecentlyPostDTO> getPostsLastTwoWeekById(@PathVariable Integer userId, @RequestParam(required=false, defaultValue = "") String order) {
        return productService.getPostsLastTwoWeekById(userId, order);
    }

    @PostMapping("promo-post")
    public ResponseEntity<SuccessDTO> createPostPromo(@RequestBody RequestPostPromoDTO requestPostPromoDTO) {
        return productService.savePostPromo(requestPostPromoDTO);
    }

    @GetMapping("promo-post/count")
    public ResponseEntity<PostPromoCountDTO> getCountPostPromoByUser(@RequestParam(required=true, defaultValue = "") Integer user_id) {
        return productService.getCountPostPromoByUser(user_id);
    }

    @GetMapping("promo-post/list")
    public ResponseEntity<PostPromoDTO> getListPostPromoByUser(@RequestParam(required=true, defaultValue = "") Integer user_id,
                                                               @RequestParam(required=false, defaultValue = "product_name_asc") String order) {
        return productService.getListPostPromoByUser(user_id, order);
    }


}
