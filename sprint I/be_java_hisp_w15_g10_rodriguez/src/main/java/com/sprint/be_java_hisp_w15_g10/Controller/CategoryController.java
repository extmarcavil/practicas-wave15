package com.sprint.be_java_hisp_w15_g10.Controller;

import com.sprint.be_java_hisp_w15_g10.DTO.Request.CategoryCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.CategoryCreatedDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.CategoryDTO;
import com.sprint.be_java_hisp_w15_g10.Service.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("categories/")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("")
    public ResponseEntity<CategoryCreatedDTO> createCategory(@Valid @RequestBody CategoryCreateDTO categoryCreateDTO) {
        return new ResponseEntity<>(categoryService.createCategory(categoryCreateDTO), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }
}
