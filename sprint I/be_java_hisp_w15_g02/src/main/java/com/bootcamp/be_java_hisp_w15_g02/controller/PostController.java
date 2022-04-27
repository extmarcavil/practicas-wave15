package com.bootcamp.be_java_hisp_w15_g02.controller;

import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.service.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsSellerByUserIdDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class PostController {
    private IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<String> createPost(@RequestBody PostCreateDTO newPost) {
        if (postService.createPost(newPost))
            return ResponseEntity.status(HttpStatus.OK).body("");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<GetPostsSellerByUserIdDTO> getListPostByFollowIdUser(@PathVariable Integer userId) {
        return new ResponseEntity<>(this.postService.getListPostByFollowIdUser(userId), HttpStatus.OK);
    }
}
