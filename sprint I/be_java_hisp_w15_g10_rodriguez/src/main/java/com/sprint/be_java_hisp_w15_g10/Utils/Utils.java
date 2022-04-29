package com.sprint.be_java_hisp_w15_g10.Utils;

import com.sprint.be_java_hisp_w15_g10.Exception.CategoryNotFoundPostException;
import com.sprint.be_java_hisp_w15_g10.Exception.PostNotFoundException;
import com.sprint.be_java_hisp_w15_g10.Exception.ProductNotFoundException;
import com.sprint.be_java_hisp_w15_g10.Exception.UserNotFoundException;
import com.sprint.be_java_hisp_w15_g10.Model.Category;
import com.sprint.be_java_hisp_w15_g10.Model.Post;
import com.sprint.be_java_hisp_w15_g10.Model.Product;
import com.sprint.be_java_hisp_w15_g10.Model.User;

import lombok.Getter;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Component;

@Getter
@Component
public class Utils {
    private final EntityUtils<Post> postUtils;
    private final EntityUtils<Category> categoryUtils;
    private final EntityUtils<Product> productUtils;
    private final EntityUtils<User> userUtils;

    public Utils(ModelMapper modelMapper) {
        postUtils = new EntityUtils<>(modelMapper);
        categoryUtils = new EntityUtils<>(modelMapper);
        productUtils = new EntityUtils<>(modelMapper);
        userUtils = new EntityUtils<>(modelMapper);
    }


    public Post getPostOrThrow(int id){
        return postUtils.getObjectByIdOrThrow(id, new PostNotFoundException("El post no fue encontrado"));
    }

    public Category getCategoryOrThrow(int id){
        return categoryUtils.getObjectByIdOrThrow(id, new CategoryNotFoundPostException("La categoría no fue encontrada"));
    }

    public Product getProductOrThrow(int id){
        return productUtils.getObjectByIdOrThrow(id, new ProductNotFoundException("El producto no fue encontrado"));
    }

    public User getUserOrThrow(int id){
        return userUtils.getObjectByIdOrThrow(id, new UserNotFoundException("El usuario no fue encontrado"));
    }

}
