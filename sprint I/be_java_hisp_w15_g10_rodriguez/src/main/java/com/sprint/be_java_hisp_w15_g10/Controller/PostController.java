package com.sprint.be_java_hisp_w15_g10.Controller;

import com.sprint.be_java_hisp_w15_g10.DTO.Request.PostCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.ProductRequestDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.PromoPostCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.*;
import com.sprint.be_java_hisp_w15_g10.Service.IPostService;
import com.sprint.be_java_hisp_w15_g10.Service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("products/")
@RestController
public class PostController {

    IPostService postService;
    IUserService userService;

    public PostController(IPostService postService, IUserService userService) {
        this.userService = userService;
        this.postService = postService;
    }

    @PostMapping("post")
    public ResponseEntity<PostCreatedDTO> createPost(@Valid @RequestBody PostCreateDTO postCreateDTO){
        return new ResponseEntity<PostCreatedDTO>(postService.createPost(postCreateDTO), HttpStatus.OK);
    }

    @PostMapping("promo-post")
    public ResponseEntity<PostCreatedDTO> createPromoPost(@Valid @RequestBody PromoPostCreateDTO promoPostCreateDTO){
        return new ResponseEntity<PostCreatedDTO>(postService.createPromoPost(promoPostCreateDTO), HttpStatus.OK);
    }

    @GetMapping("promo-post/count")
    public ResponseEntity<UserWithPromoPostCountDTO> getUserWitPromoPostsCount(@RequestParam int user_id){
        return new ResponseEntity<UserWithPromoPostCountDTO>(userService.getUsersWithPromoPostCount(user_id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<ProductResponseDTO>> getProducts(){
        return new ResponseEntity<List<ProductResponseDTO>>(postService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserPostResponseDTO> getAllPostsByFollowerId(@PathVariable int userId, @RequestParam(defaultValue = "date_asc") String order){
        return new ResponseEntity<UserPostResponseDTO>(postService.getAllPostsByFollowerId(userId, order), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<UserPromoPostResponseDTO> getAllPromoPostsBySellerId(@RequestParam int user_id, @RequestParam(defaultValue = "date_asc") String order){
        return new ResponseEntity<UserPromoPostResponseDTO>(postService.getAllPromoPostsBySellerId(user_id, order), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<PostResponseDTO>> getAllPosts(){
        return new ResponseEntity<List<PostResponseDTO>>(postService.getAllPosts(), HttpStatus.OK);
    }


}
