package com.social.media.sprgbt.unit.service;

import com.social.media.sprgbt.dto.CategoryDto;
import com.social.media.sprgbt.entity.Category;
import com.social.media.sprgbt.exception.ExistingException;
import com.social.media.sprgbt.exception.NotFoundException;
import com.social.media.sprgbt.mapper.CategoryMapper;
import com.social.media.sprgbt.repository.ICategoryRepository;
import com.social.media.sprgbt.service.impl.CategoryServiceImpl;
import com.social.media.sprgbt.utils.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    /**
     * Mocks
     */
    @Mock
    ICategoryRepository categoryRepository;

    @Mock
    private CategoryMapper categoryMapper;

    @InjectMocks
    CategoryServiceImpl categoryService;


    /**
     * Tests
     */
    @Test
    @DisplayName("Test Create CategoryDto Exizting ")
    void createCategoryExistingTest() {
        //Arrange
        when(categoryRepository.getCategoryByName(Data.CATEGORY_DTO_SPORT_EXTREME.getNameCategory()))
                .thenReturn(null);

        when(categoryMapper.mapToEntity(Data.CATEGORY_DTO_SPORT_EXTREME)).thenReturn(Data.CATEGORY_SPORT_EXTREME);

        when(categoryRepository.createCategory(Data.CATEGORY_SPORT_EXTREME)).then(invocationOnMock -> {
            Data.CATEGORY_SPORT_EXTREME.setCategoryId(1);
            return Data.CATEGORY_SPORT_EXTREME;
        });

        when(categoryMapper.mapToDto(Data.CATEGORY_SPORT_EXTREME)).then(invocationOnMock -> {
            Data.CATEGORY_DTO_SPORT_EXTREME.setCategoryId(1);
            return Data.CATEGORY_DTO_SPORT_EXTREME;
        });

        //Act
        CategoryDto result = categoryService.createCategory(Data.CATEGORY_DTO_SPORT_EXTREME);

        //Assert
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(1, result.getCategoryId()),
                () -> assertEquals(Data.CATEGORY_DTO_SPORT_EXTREME.getNameCategory(), result.getNameCategory())
        );
        verify(categoryRepository).getCategoryByName(anyString());
        verify(categoryMapper).mapToEntity(any(CategoryDto.class));
        verify(categoryRepository).createCategory(any(Category.class));
        verify(categoryMapper).mapToDto(any(Category.class));

    }

    @Test
    @DisplayName("Test Create CategoryDto")
    void createCategoryTest() {
        //Arrange
        when(categoryRepository.getCategoryByName(Data.CATEGORY_DTO_SPORT_EXTREME.getNameCategory()))
                .thenReturn(Data.CATEGORY_SPORT_EXTREME);

        //Act
        //Assert
        ExistingException e = assertThrows(ExistingException.class, () -> {
            categoryService.createCategory(Data.CATEGORY_DTO_SPORT_EXTREME);
        });
        assertEquals("La Categoria con nameCategory: Sports Extreme ya existe en la BD.", e.getMessage());
        verify(categoryRepository).getCategoryByName(anyString());

    }


    @Test
    @DisplayName("Test Get All CategoryDto ")
    void getAllCategoryTest() {
        //Arrange
        when(categoryRepository.getAllCategory())
                .thenReturn(List.of(Data.CATEGORY_SPORT_EXTREME, Data.CATEGORY_SPORT_CARS));

        when(categoryMapper.mapToDto(Data.CATEGORY_SPORT_EXTREME)).thenReturn(Data.CATEGORY_DTO_SPORT_EXTREME);

        //Act
        List<CategoryDto> resultList = categoryService.getAllCategory();

        //Assert
        assertAll(
                () -> assertNotNull(resultList),
                () -> assertEquals(2, resultList.size())
        );
        verify(categoryRepository).getAllCategory();
        verify(categoryMapper, times(2)).mapToDto(any(Category.class));

    }


    @Test
    @DisplayName("Test Get CategoryDto By id ")
    void getCategoryByIdTest() {
        //Arrange
        when(categoryRepository.getCategoryById(1)).then(invocationOnMock -> {
            Data.CATEGORY_SPORT_EXTREME.setCategoryId(1);
            return Data.CATEGORY_SPORT_EXTREME;
        });

        when(categoryMapper.mapToDto(Data.CATEGORY_SPORT_EXTREME))
                .then(invocationOnMock -> {
                    Data.CATEGORY_DTO_SPORT_EXTREME.setCategoryId(1);
                    return Data.CATEGORY_DTO_SPORT_EXTREME;
                });

        //Act
        CategoryDto result = categoryService.getCategoryById(1);

        //Assert
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(1, result.getCategoryId()),
                () -> assertEquals(Data.CATEGORY_DTO_SPORT_EXTREME.getNameCategory(), result.getNameCategory())
        );
        verify(categoryRepository).getCategoryById(anyInt());
        verify(categoryMapper, times(1)).mapToDto(any(Category.class));

    }


    @Test
    @DisplayName("Test Get CategoryDto By id Not Found ")
    void getCategoryByIdNotFoundTest() {
        //Arrange
        when(categoryRepository.getCategoryById(10)).thenReturn(null);

        //Act
        //Assert
        NotFoundException e = assertThrows(NotFoundException.class, () -> {
            categoryService.getCategoryById(10);
        });
        assertEquals("La Category con iD: 10 no existe en la BD.", e.getMessage());
        verify(categoryRepository).getCategoryById(anyInt());

    }


    @Test
    @DisplayName("Test Get CategoryDto By Name ")
    void getCategoryByNameTest() {
        //Arrange
        when(categoryRepository.getCategoryByName(Data.CATEGORY_SPORT_EXTREME.getNameCategory())).then(invocationOnMock -> {
            Data.CATEGORY_SPORT_EXTREME.setCategoryId(1);
            return Data.CATEGORY_SPORT_EXTREME;
        });

        when(categoryMapper.mapToDto(Data.CATEGORY_SPORT_EXTREME))
                .then(invocationOnMock -> {
                    Data.CATEGORY_DTO_SPORT_EXTREME.setCategoryId(1);
                    return Data.CATEGORY_DTO_SPORT_EXTREME;
                });

        //Act
        CategoryDto result = categoryService.getCategoryByName(Data.CATEGORY_SPORT_EXTREME.getNameCategory());

        //Assert
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(1, result.getCategoryId()),
                () -> assertEquals(Data.CATEGORY_DTO_SPORT_EXTREME.getNameCategory(), result.getNameCategory())
        );
        verify(categoryRepository).getCategoryByName(anyString());
        verify(categoryMapper, times(1)).mapToDto(any(Category.class));

    }

    @Test
    @DisplayName("Test Get CategoryDto Name id Not Found ")
    void getCategoryNameIdNotFoundTest() {
        //Arrange
        when(categoryRepository.getCategoryByName(Data.CATEGORY_SPORT_EXTREME.getNameCategory())).thenReturn(null);

        //Act
        //Assert
        NotFoundException e = assertThrows(NotFoundException.class, () -> {
            categoryService.getCategoryByName(Data.CATEGORY_SPORT_EXTREME.getNameCategory());
        });
        assertEquals("La Category con name: Sports Extreme no existe en la BD.", e.getMessage());
        verify(categoryRepository).getCategoryByName(anyString());

    }
}

