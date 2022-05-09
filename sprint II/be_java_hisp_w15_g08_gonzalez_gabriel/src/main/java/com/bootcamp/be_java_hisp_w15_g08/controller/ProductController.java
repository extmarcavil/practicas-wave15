package com.bootcamp.be_java_hisp_w15_g08.controller;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.PostListDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.PostNotUserIdDTO;
import com.bootcamp.be_java_hisp_w15_g08.service.IProductService;
import com.bootcamp.be_java_hisp_w15_g08.service.IUserService;
import com.bootcamp.be_java_hisp_w15_g08.service.ProductService;
import com.bootcamp.be_java_hisp_w15_g08.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    IProductService service;
    public ProductController(IProductService service) {

        this.service = service;
    }


    @PostMapping("/products/post")
    public ResponseEntity<PostNotUserIdDTO> createPost(@RequestBody NewPostDTO newPostDTO) {
        PostNotUserIdDTO newPostDTO1 = service.addPost(newPostDTO);
        return new ResponseEntity<>(newPostDTO1, HttpStatus.ACCEPTED);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PostListDTO> getSellersLastsPosts(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        if (order != null && !order.equals("date_asc") && !order.equals("date_desc")) {
            throw new IllegalArgumentException("Parametro incorrecto, verificar el parametro ingresado");
        }
        PostListDTO postListDTO = service.getSellersLastsPosts(userId, order);
        return new ResponseEntity<>(postListDTO, HttpStatus.ACCEPTED);
    }

}
