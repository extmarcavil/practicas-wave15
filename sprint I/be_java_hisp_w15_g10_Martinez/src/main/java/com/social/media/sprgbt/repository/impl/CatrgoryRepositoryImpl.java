package com.social.media.sprgbt.repository.impl;

import com.social.media.sprgbt.entity.Category;
import com.social.media.sprgbt.repository.ICategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Repository
public class CatrgoryRepositoryImpl implements ICategoryRepository {


    /**
     * Lista de Categorias
     */
    private final List<Category> categoryList;

    private static final AtomicInteger count = new AtomicInteger(0);

    /**
     * Inyeccion de dependencias por constructor
     *
     * @param categoryList
     */
    public CatrgoryRepositoryImpl(List<Category> categoryList) {
        this.categoryList = categoryList;
    }


    /**
     * Loading Categories
     */
    @PostConstruct
    private void loadingCategories() {
        Category cat1 = new Category(count.incrementAndGet(), "Tecnologia");
        Category cat2 = new Category(count.incrementAndGet(), "Electrodomesticos");
        Category cat3 = new Category(count.incrementAndGet(), "Accesorios");
        Category cat4 = new Category(count.incrementAndGet(), "Aseo");
        Category cat5 = new Category(count.incrementAndGet(), "Deporte");

        categoryList.add(cat1);
        categoryList.add(cat2);
        categoryList.add(cat3);
        categoryList.add(cat4);
        categoryList.add(cat5);
    }


    /**
     * Create Category
     *
     * @param category
     * @return {@link Category} obj
     */
    @Override
    public Category createCategory(Category category) {
        category.setCategoryId(count.incrementAndGet());

        log.info("Category: {}", category);
        categoryList.add(category);

        return category;
    }

    /**
     * Get All Category
     *
     * @return
     */
    @Override
    public List<Category> getAllCategory() {
        return categoryList;
    }

    /**
     * Get Category By id
     *
     * @param id
     * @return {@link Category} obj
     */
    @Override
    public Category getCategoryById(Integer id) {
        Optional<Category> cat = categoryList.stream()
                .filter(c -> c.getCategoryId().equals(id))
                .findFirst();

        return cat.orElse(null);
    }

    /**
     * Get Category By nameCategory
     *
     * @param categoryName param
     * @return {@link Category} obj
     */
    @Override
    public Category getCategoryByName(String categoryName) {
        Optional<Category> cat = categoryList.stream()
                .filter(c -> c.getNameCategory().equalsIgnoreCase(categoryName))
                .findFirst();

        return cat.orElse(null);
    }


}
