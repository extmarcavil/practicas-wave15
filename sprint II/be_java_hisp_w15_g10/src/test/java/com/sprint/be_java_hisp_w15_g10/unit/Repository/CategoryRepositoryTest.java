package com.sprint.be_java_hisp_w15_g10.unit.Repository;

import com.sprint.be_java_hisp_w15_g10.Model.Category;
import com.sprint.be_java_hisp_w15_g10.Repository.CategoryRepository;
import com.sprint.be_java_hisp_w15_g10.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;


class CategoryRepositoryTest {

    CategoryRepository categoryRepository;

    @BeforeEach
    void setUp(){
        categoryRepository = new CategoryRepository();
    }

    @Test
    void getValidCategoryById() {
        // arrange
        Category category = TestUtils.createCategory();
        categoryRepository.add(category);

        //act
        Optional<Category> oCategory = categoryRepository.getById(4);

        // assert
        Assertions.assertEquals(oCategory.get(), category);
    }

    @Test
    void getInvalidUserById() {
        // arrange
        categoryRepository.add(TestUtils.createCategory());

        //act
        Optional<Category> category = categoryRepository.getById(10);

        // assert
        Assertions.assertTrue(category.isEmpty());
    }

    @Test
    void getAll() {
        // arrange
        categoryRepository.add(TestUtils.createCategory());

        //act
        List<Category> categories = categoryRepository.getAll();

        // assert
        Assertions.assertAll(
                ()->{Assertions.assertFalse(categories.isEmpty());},
                ()->{Assertions.assertEquals(categories.size(),4);}
        );
    }

    @Test
    void add() {
        // arrange
        Category category = TestUtils.createCategory();
        categoryRepository.add(category);
        int initial_size = categoryRepository.getAll().size();
        // act
        categoryRepository.add(category);
        int final_size = categoryRepository.getAll().size();
        // assert
        Assertions.assertAll(
                ()->{Assertions.assertEquals(initial_size + 1, final_size);},
                ()->{Assertions.assertEquals(category, categoryRepository.getById(4).get());}
        );
    }
}