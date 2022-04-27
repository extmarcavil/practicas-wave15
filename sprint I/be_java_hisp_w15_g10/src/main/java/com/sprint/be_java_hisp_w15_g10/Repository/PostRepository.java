package com.sprint.be_java_hisp_w15_g10.Repository;

import com.sprint.be_java_hisp_w15_g10.Model.Category;
import com.sprint.be_java_hisp_w15_g10.Model.Post;
import com.sprint.be_java_hisp_w15_g10.Model.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
    private List<Post> postList;
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public PostRepository(CategoryRepository categoryRepository, ProductRepository productRepository){
        postList = new ArrayList<Post>();
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;

        List<Product> productList = productRepository.getAllProducts();
        List<Category> categoryList = categoryRepository.getAllCategories();

        Post post1 = new Post(productList.get(0), LocalDate.now(), categoryList.get(0), 1.09, false, 0);
        Post post2 = new Post(productList.get(1), LocalDate.now(), categoryList.get(1), 2.10, true, 0.5);
        Post post3 = new Post(productList.get(2), LocalDate.now(), categoryList.get(2), 1.99, false, 0);
        Post post4 = new Post(productList.get(3), LocalDate.now(), categoryList.get(0), 3.00, true, 0.4);
        Post post5 = new Post(productList.get(4), LocalDate.now(), categoryList.get(2), 2.98, true, 0.1);

        postList.add(post1);
        postList.add(post2);
        postList.add(post3);
        postList.add(post4);
        postList.add(post5);
    }
}
