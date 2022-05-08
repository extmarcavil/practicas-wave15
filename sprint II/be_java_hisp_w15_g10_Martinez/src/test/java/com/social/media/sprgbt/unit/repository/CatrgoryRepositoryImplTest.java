package com.social.media.sprgbt.unit.repository;

import com.social.media.sprgbt.entity.Category;
import com.social.media.sprgbt.repository.ICategoryRepository;
import com.social.media.sprgbt.repository.impl.CatrgoryRepositoryImpl;
import com.social.media.sprgbt.utils.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.social.media.sprgbt.repository.impl.CatrgoryRepositoryImpl.categoryList;
import static org.junit.jupiter.api.Assertions.*;

class CatrgoryRepositoryImplTest {


    /**
     * Instancia de la clase a testear CategoryRepositoryImpl
     */
    private ICategoryRepository categoryRepositoryImpl;


    @BeforeEach
    void setUp() {
        categoryRepositoryImpl = new CatrgoryRepositoryImpl();
        CatrgoryRepositoryImpl.categoryList = new ArrayList<>();
        CatrgoryRepositoryImpl.count = new AtomicInteger(0);
    }


    @Test
    @DisplayName("Test Create Category")
    void createCategoryTest() {
        //Arrange
        Category category = Data.CATEGORY_SPORT_EXTREME;

        //Act
        Category result = categoryRepositoryImpl.createCategory(category);

        //Assert
        assertAll(
                () -> assertTrue(!categoryList.isEmpty()),
                () -> assertNotNull(result),
                () -> assertEquals(1, result.getCategoryId()),
                () -> assertEquals(category.getNameCategory(), result.getNameCategory())
        );
    }

    @Test
    @DisplayName("Test Get All Category")
    void getAllCategoryTest() {
        //Arrange
        Category sport_extreme = Data.CATEGORY_SPORT_EXTREME;
        Category sports_cars = Data.CATEGORY_SPORT_CARS;
        Category technology = Data.CATEGORY_TECHNOLOGY;

        categoryRepositoryImpl.createCategory(sport_extreme);
        categoryRepositoryImpl.createCategory(sports_cars);
        categoryRepositoryImpl.createCategory(technology);

        //Act
        List<Category> list = categoryRepositoryImpl.getAllCategory();

        //Assert
        assertAll(
                () -> assertTrue(!list.isEmpty()),
                () -> assertEquals(3, list.size()),
                () -> assertEquals(sport_extreme.getCategoryId(), list.get(0).getCategoryId()),
                () -> assertEquals(sport_extreme.getNameCategory(), list.get(0).getNameCategory())
        );
    }

    @Test
    @DisplayName("Test Get Category By id")
    void getCategoryByIdTest() {
        //Arrange
        Category sport_extreme = Data.CATEGORY_SPORT_EXTREME;
        Category sports_cars = Data.CATEGORY_SPORT_CARS;
        Category technology = Data.CATEGORY_TECHNOLOGY;

        categoryRepositoryImpl.createCategory(sport_extreme);
        categoryRepositoryImpl.createCategory(sports_cars);
        categoryRepositoryImpl.createCategory(technology);

        //Act
        Category result = categoryRepositoryImpl.getCategoryById(3);

        //Assert
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(technology.getCategoryId(), result.getCategoryId()),
                () -> assertEquals(technology.getNameCategory(), result.getNameCategory())
        );
    }

    @Test
    @DisplayName("Test Get Category By id Not Found")
    void getCategoryByIdNotFoundTest() {
        //Arrange
        Category sport_extreme = Data.CATEGORY_SPORT_EXTREME;
        Category sports_cars = Data.CATEGORY_SPORT_CARS;
        Category technology = Data.CATEGORY_TECHNOLOGY;

        categoryRepositoryImpl.createCategory(sport_extreme);
        categoryRepositoryImpl.createCategory(sports_cars);
        categoryRepositoryImpl.createCategory(technology);

        //Act
        Category result = categoryRepositoryImpl.getCategoryById(4);

        //Assert
        assertNull(result);

    }


    @Test
    @DisplayName("Test Get Category By nameCategory")
    void getCategoryByNameTest() {
        //Arrange
        Category sport_extreme = Data.CATEGORY_SPORT_EXTREME;
        Category sports_cars = Data.CATEGORY_SPORT_CARS;
        Category technology = Data.CATEGORY_TECHNOLOGY;

        categoryRepositoryImpl.createCategory(sport_extreme);
        categoryRepositoryImpl.createCategory(sports_cars);
        categoryRepositoryImpl.createCategory(technology);

        //Act
        Category result = categoryRepositoryImpl.getCategoryByName("Sport Cars");

        //Assert
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(sports_cars.getCategoryId(), result.getCategoryId()),
                () -> assertEquals(sports_cars.getNameCategory(), result.getNameCategory())
        );
    }


    @Test
    @DisplayName("Test Get Category By Name Not Found")
    void getCategoryByNameNotFoundTest() {
        //Arrange
        Category sport_extreme = Data.CATEGORY_SPORT_EXTREME;
        Category sports_cars = Data.CATEGORY_SPORT_CARS;
        Category technology = Data.CATEGORY_TECHNOLOGY;

        categoryRepositoryImpl.createCategory(sport_extreme);
        categoryRepositoryImpl.createCategory(sports_cars);
        categoryRepositoryImpl.createCategory(technology);

        //Act
        Category result = categoryRepositoryImpl.getCategoryByName("Action");

        //Assert
        assertNull(result);

    }

}