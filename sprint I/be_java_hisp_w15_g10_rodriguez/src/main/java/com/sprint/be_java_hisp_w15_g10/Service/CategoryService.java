package com.sprint.be_java_hisp_w15_g10.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Request.CategoryCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.CategoryCreatedDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.CategoryDTO;
import com.sprint.be_java_hisp_w15_g10.Exception.DuplicatedEntityException;
import com.sprint.be_java_hisp_w15_g10.Model.Category;
import com.sprint.be_java_hisp_w15_g10.Utils.Utils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    private final Utils utils;

    public CategoryService(Utils utils) {
        this.utils = utils;
    }

    @Override
    public CategoryCreatedDTO createCategory(CategoryCreateDTO categoryCreateDTO) {
        if(utils.getCategoryUtils().addObject(utils.getCategoryUtils().convertToEntity(categoryCreateDTO, new Category()),categoryCreateDTO.getCategory_name()))
            return new CategoryCreatedDTO("Se ha creado la categoría " + categoryCreateDTO.getCategory_name() + " con éxito.");
        throw new DuplicatedEntityException("La categoría con nombre " + categoryCreateDTO.getCategory_name() + " ya se encuentra registrada");
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return utils.getCategoryUtils().convertToListOfDTO(utils.getCategoryUtils().getAllObjects(), new CategoryDTO());
    }

}
