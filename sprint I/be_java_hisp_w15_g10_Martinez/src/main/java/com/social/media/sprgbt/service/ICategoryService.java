package com.social.media.sprgbt.service;

import com.social.media.sprgbt.dto.CategoryDto;
import com.social.media.sprgbt.entity.Category;

import java.util.List;

public interface ICategoryService {

    /**
     * Create CategoryDto
     *
     * @param categoryDto
     * @return {@link Category} obj
     */
    CategoryDto createCategory(CategoryDto categoryDto);

    /**
     * Get All CategoryDto
     *
     * @return
     */
    List<CategoryDto> getAllCategory();

    /**
     * Get CategoryDto By id
     *
     * @param id
     * @return {@link CategoryDto} obj
     */
    CategoryDto getCategoryById(Integer id);

    /**
     * Get Category By nameCategory
     *
     * @param categoryName param
     * @return {@link Category} obj
     */
    CategoryDto getCategoryByName(String categoryName);


}
