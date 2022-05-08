package com.social.media.sprgbt.repository;

import com.social.media.sprgbt.entity.Category;

import java.util.List;

public interface ICategoryRepository {

    /**
     * Create Category
     *
     * @param category
     * @return {@link Category} obj
     */
    Category createCategory(Category category);

    /**
     * Get All Category
     *
     * @return
     */
    List<Category> getAllCategory();

    /**
     * Get Category By id
     *
     * @param id
     * @return {@link Category} obj
     */
    Category getCategoryById(Integer id);

    /**
     * Get Category By nameCategory
     *
     * @param categoryName param
     * @return {@link Category} obj
     */
    Category getCategoryByName(String categoryName);
}
