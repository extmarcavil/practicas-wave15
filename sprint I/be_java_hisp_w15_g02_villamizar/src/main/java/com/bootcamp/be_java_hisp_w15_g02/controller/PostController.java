package com.bootcamp.be_java_hisp_w15_g02.controller;

import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsCountDTO;
import com.bootcamp.be_java_hisp_w15_g02.service.IPostService;
import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsDTO;

@RestController
@RequestMapping("/products")
public class PostController {
    private IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @PostMapping({"/post","/promo-post"})
    public ResponseEntity<String> createPost(@RequestBody PostCreateDTO newPost) {
        if (postService.createPost(newPost))
            return ResponseEntity.status(HttpStatus.OK).body("");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<GetPostsDTO> getListPostByFollowIdUser(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(this.postService.getListPostByFollowIdUser(userId, order), HttpStatus.OK);
    }
    @GetMapping("/promo-post/list")
    public ResponseEntity<GetPostsDTO> getListPromoPostByIdUser(@RequestParam Integer user_Id) {
        return new ResponseEntity<>(this.postService.getListPromoPostByIdUser(user_Id), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<GetPostsCountDTO> getPromoCountByIdUser(@RequestParam Integer user_Id) {
        return new ResponseEntity<>(this.postService.getPromoCountByIdUser(user_Id), HttpStatus.OK);
    }
}
