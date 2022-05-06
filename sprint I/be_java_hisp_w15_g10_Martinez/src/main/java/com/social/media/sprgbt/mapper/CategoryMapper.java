package com.social.media.sprgbt.mapper;

import com.social.media.sprgbt.dto.CategoryDto;
import com.social.media.sprgbt.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    @Autowired
    private ModelMapper mapper;

    public Category mapToEntity(CategoryDto dto) {

        Category entity = mapper.map(dto, Category.class);

        return entity;
    }


    public CategoryDto mapToDto(Category entity) {

        CategoryDto dto = mapper.map(entity, CategoryDto.class);

        return dto;
    }
}
