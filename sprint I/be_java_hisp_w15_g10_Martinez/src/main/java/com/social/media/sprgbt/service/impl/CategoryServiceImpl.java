package com.social.media.sprgbt.service.impl;

import com.social.media.sprgbt.dto.CategoryDto;
import com.social.media.sprgbt.entity.Category;
import com.social.media.sprgbt.exception.ExistingException;
import com.social.media.sprgbt.exception.NotFoundException;
import com.social.media.sprgbt.mapper.CategoryMapper;
import com.social.media.sprgbt.repository.ICategoryRepository;
import com.social.media.sprgbt.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategoryServiceImpl implements ICategoryService {


    /**
     * Instancia del Category Repository
     */
    private final ICategoryRepository categoryRepository;

    /**
     * Instancia Categpry Mapper.
     */
    private final CategoryMapper categoryMapper;

    /**
     * Inyeccion de dependencias por constructor
     *
     * @param categoryService
     * @param categoryMapper
     */
    public CategoryServiceImpl(ICategoryRepository categoryService, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryService;
        this.categoryMapper = categoryMapper;
    }

    /**
     * Create CategoryDto
     *
     * @param categoryDto
     * @return {@link CategoryDto} obj
     */
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) throws ExistingException {

        if (categoryRepository.getCategoryByName(categoryDto.getNameCategory()) != null) {
            throw new ExistingException(String.format("La Categoria con nameCategory: %s ya existe en la BD.", categoryDto.getNameCategory()));
        }

        Category entity = categoryMapper.mapToEntity(categoryDto);
        Category entityRepo = categoryRepository.createCategory(entity);

        return categoryMapper.mapToDto(entityRepo);
    }

    /**
     * Get All CategoryDto
     *
     * @return
     */
    @Override
    public List<CategoryDto> getAllCategory() {
        List<CategoryDto> listDto = categoryRepository.getAllCategory().stream()
                .map(c -> categoryMapper.mapToDto(c))
                .collect(Collectors.toList());

        return listDto;
    }

    /**
     * Get CategoryDto By id
     *
     * @param id
     * @return {@link CategoryDto} obj
     */
    @Override
    public CategoryDto getCategoryById(Integer id) throws NotFoundException {

        Category catEntity = categoryRepository.getCategoryById(id);

        if (catEntity == null) {
            throw new NotFoundException(String.format("La Category con iD: %s no existe en la BD.", id));
        }

        log.info("Category: {}", catEntity);

        return categoryMapper.mapToDto(catEntity);
    }

    /**
     * Get Category By nameCategory
     *
     * @param categoryName param
     * @return {@link Category} obj
     */
    @Override
    public CategoryDto getCategoryByName(String categoryName) {

        Category catEntity = categoryRepository.getCategoryByName(categoryName);

        if (catEntity == null) {
            throw new NotFoundException(String.format("La Category con name: %s no existe en la BD.", categoryName));
        }

        log.info("Category: {}", catEntity);

        return categoryMapper.mapToDto(catEntity);
    }


}
