package com.sprint.be_java_hisp_w15_g10.Repository;

import com.sprint.be_java_hisp_w15_g10.Model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    private final List<Category> categoryList;

    public CategoryRepository(){
        categoryList = new ArrayList<Category>();
        Category category1 = new Category(1, "Hogar");
        Category category2 = new Category(2, "Ropa");
        Category category3 = new Category(3, "Accesorios");

        categoryList.add(category1);
        categoryList.add(category2);
        categoryList.add(category3);
    }

    public List<Category> getAll(){
        return categoryList;
    }

    public Optional<Category> getById(int id){
        return categoryList.stream()
                .filter(user -> user.getCategory_id()==id)
                .findFirst();
    }

    public void add(Category category){
        categoryList.add(category);
    }

}
