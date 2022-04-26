package com.sprint.be_java_hisp_w15_g10.Repository;

import com.sprint.be_java_hisp_w15_g10.Model.Category;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {
    private List<Category> categoryList = new ArrayList<Category>();

    public CategoryRepository(){
        Category category1 = new Category(1, "Hogar");
        Category category2 = new Category(2, "Ropa");
        Category category3 = new Category(3, "Accesorios");

        categoryList.add(category1);
        categoryList.add(category2);
        categoryList.add(category3);
    }

    public List<Category> getAllCategories(){
        return categoryList;
    }

}
