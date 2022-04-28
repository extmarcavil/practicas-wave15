package com.sprint.be_java_hisp_w15_g10.Controller;

import com.sprint.be_java_hisp_w15_g10.DTO.Request.PostCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.PostPromoCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.ProductRequestDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.*;
import com.sprint.be_java_hisp_w15_g10.Service.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("products/")
@RestController
public class PostController {

    IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @PostMapping("post")
    public ResponseEntity<PostCreatedDTO> createPost(@Valid @RequestBody PostCreateDTO postCreateDTO){
        return new ResponseEntity<PostCreatedDTO>(postService.createPost(postCreateDTO), HttpStatus.OK);
    }

    @PostMapping("post/promo-post")
    public ResponseEntity<PostCreatedDTO> createPostPromo(@Valid @RequestBody PostPromoCreateDTO postPromoCreateDTO){
        return new ResponseEntity<PostCreatedDTO>(postService.createPost(postPromoCreateDTO), HttpStatus.OK);
    }

    @GetMapping("promo-post/count")
    public ResponseEntity<PostCountDTO> countPostPromo(@RequestParam int user_id){
        return new ResponseEntity<PostCountDTO>(postService.countPostPromo(user_id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<ProductResponseDTO>> getProducts(){
        return new ResponseEntity<List<ProductResponseDTO>>(postService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserPostResponseDTO> getAllPostsByFollowerId(@PathVariable int userId, @RequestParam(defaultValue = "date_asc") String order){
        return new ResponseEntity<UserPostResponseDTO>(postService.getAllPostsByFollowerId(userId, order), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<PostResponseDTO>> getAllPosts(){
        return new ResponseEntity<List<PostResponseDTO>>(postService.getAllPosts(), HttpStatus.OK);
    }


}
