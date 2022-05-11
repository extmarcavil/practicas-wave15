package com.sprint.be_java_hisp_w15_g10.Repository;

import com.sprint.be_java_hisp_w15_g10.Model.Category;
import com.sprint.be_java_hisp_w15_g10.Model.Post;
import com.sprint.be_java_hisp_w15_g10.Model.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
    private final List<Post> postList;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private int index;

    public PostRepository(CategoryRepository categoryRepository, ProductRepository productRepository){
        postList = new ArrayList<Post>();
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.index = 0;

        List<Product> productList = productRepository.getAll();
        List<Category> categoryList = categoryRepository.getAll();

        Post post1 = new Post(index++, productList.get(0), LocalDate.of(2022, 5, 3), categoryList.get(0), 1.09, false, 0);
        Post post2 = new Post(index++, productList.get(1), LocalDate.now(), categoryList.get(1), 2.10, true, 0.5);
        Post post3 = new Post(index++, productList.get(2), LocalDate.now(), categoryList.get(2), 1.99, false, 0);
        Post post4 = new Post(index++, productList.get(3), LocalDate.now(), categoryList.get(0), 3.00, true, 0.4);
        Post post5 = new Post(index++, productList.get(4), LocalDate.now(), categoryList.get(2), 2.98, true, 0.1);

        postList.add(post1);
        postList.add(post2);
        postList.add(post3);
        postList.add(post4);
        postList.add(post5);

    }

    public List<Post> getAll(){
        return postList;
    }

    public void add(Post post){
        postList.add(post);
    }

    public Optional<Post> getById(int id){
        return postList.stream()
                .filter(post -> post.getPost_id()==id)
                .findFirst();
    }

    public int nextIndex(){return index++;}
}
