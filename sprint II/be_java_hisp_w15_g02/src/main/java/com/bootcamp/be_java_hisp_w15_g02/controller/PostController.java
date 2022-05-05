package com.bootcamp.be_java_hisp_w15_g02.controller;

import com.bootcamp.be_java_hisp_w15_g02.service.IPostService;
import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetPostsSellerByUserIdDTO;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/products")
@Validated
public class PostController {
    private IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<String> createPost(@Valid @RequestBody PostCreateDTO newPost) {
        if (postService.createPost(newPost))
            return ResponseEntity.status(HttpStatus.OK).body("");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<GetPostsSellerByUserIdDTO> getListPostByFollowIdUser(@PathVariable @NotNull(message = "El id no puede estar vacio")
                                                                                   @Min(value = 1, message = "El id debe ser mayor a 0")
                                                                                   Integer userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(this.postService.getListPostByFollowIdUser(userId, order), HttpStatus.OK);
    }
}
