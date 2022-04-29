package com.sprint.be_java_hisp_w15_g10.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Request.CategoryCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.CategoryCreatedDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    CategoryCreatedDTO createCategory(CategoryCreateDTO postCreateDTO);
    List<CategoryDTO> getAllCategories();
}
