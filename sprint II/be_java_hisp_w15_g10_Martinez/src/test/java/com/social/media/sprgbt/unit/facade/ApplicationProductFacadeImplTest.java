package com.social.media.sprgbt.unit.facade;

import com.social.media.sprgbt.dto.*;
import com.social.media.sprgbt.exception.ExistingException;
import com.social.media.sprgbt.exception.OrderNotExistingException;
import com.social.media.sprgbt.facade.impl.ApplicationProductFacadeImpl;
import com.social.media.sprgbt.service.*;
import com.social.media.sprgbt.utils.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicationProductFacadeImplTest {


    @Mock
    IPostService postService;

    @Mock
    ICategoryService categoryService;

    @Mock
    IProductoService productoService;

    @Mock
    IUserService userService;

    @Mock
    IFollowerService followerService;

    @InjectMocks
    ApplicationProductFacadeImpl productFacadeImpl;


    /**
     * Test PRODUCTS
     */

    @Test
    @DisplayName("Test Create Product")
    void createProductTest() {
        //Arrange
        when(productoService.createProduct(Data.PRODUCTDTO_SPORT)).then(invocationOnMock -> {
            Data.PRODUCTDTO_SPORT.setProductId(1);
            return Data.PRODUCTDTO_SPORT;
        });

        //Act
        ProductoDto productDto = productFacadeImpl.createProduct(Data.PRODUCTDTO_SPORT);

        //Assert
        assertNotNull(productDto);
        assertEquals(1, productDto.getProductId());
        verify(productoService).createProduct(any(ProductoDto.class));
    }


    @Test
    @DisplayName("Test Get All Products")
    void getAllProductsTest() {
        //Arrange
        when(productoService.getAllProducts())
                .thenReturn(List.of(Data.PRODUCTDTO_SPORT, Data.PRODUCTDTO_TECHNOLOGY));

        //Act
        List<ProductoDto> productDto = productFacadeImpl.getAllProducts();

        //Assert
        assertNotNull(productDto);
        assertEquals(2, productDto.size());
        assertEquals(Data.PRODUCTDTO_SPORT.getProductName(), productDto.get(0).getProductName());
        verify(productoService).getAllProducts();
    }


    @Test
    @DisplayName("Test Get Product By Id")
    void getProductByIdTest() {
        //Arrange
        when(productoService.getProductById(1)).then(invocationOnMock -> {
            Data.PRODUCTDTO_SPORT.setProductId(1);
            return Data.PRODUCTDTO_SPORT;
        });


        //Act
        ProductoDto productDto = productFacadeImpl.getProductById(1);

        //Assert
        assertNotNull(productDto);
        assertEquals(1, productDto.getProductId());
        assertEquals(Data.PRODUCTDTO_SPORT.getProductName(), productDto.getProductName());
        verify(productoService).getProductById(anyInt());
    }


    /**
     * Tests CATEGORY
     */

    @Test
    @DisplayName("Test Create CategoryDto")
    void createCategoryTest() {
        //Arrange
        when(categoryService.createCategory(Data.CATEGORY_DTO_SPORT_EXTREME)).then(invocationOnMock -> {
            Data.CATEGORY_DTO_SPORT_EXTREME.setCategoryId(1);
            return Data.CATEGORY_DTO_SPORT_EXTREME;
        });


        //Act
        CategoryDto category = productFacadeImpl.createCategory(Data.CATEGORY_DTO_SPORT_EXTREME);

        //Assert
        assertNotNull(category);
        assertEquals(1, category.getCategoryId());
        assertEquals(Data.CATEGORY_DTO_SPORT_EXTREME.getNameCategory(), category.getNameCategory());
        verify(categoryService).createCategory(any(CategoryDto.class));
    }


    @Test
    @DisplayName("Test Get All CategoryDto")
    void getAllCategoryTest() {
        //Arrange
        when(categoryService.getAllCategory())
                .thenReturn(List.of(Data.CATEGORY_DTO_SPORT_EXTREME));

        //Act
        List<CategoryDto> categorys = productFacadeImpl.getAllCategory();

        //Assert
        assertNotNull(categorys);
        assertEquals(1, categorys.size());
        assertEquals(Data.CATEGORY_DTO_SPORT_EXTREME.getNameCategory(), categorys.get(0).getNameCategory());
        verify(categoryService).getAllCategory();
    }


    @Test
    @DisplayName("Test Get CategoryDto By id")
    void getCategoryById() {
        //Arrange
        when(categoryService.getCategoryById(1))
                .then(invocationOnMock -> {
                    Data.CATEGORY_DTO_SPORT_EXTREME.setCategoryId(1);
                    return Data.CATEGORY_DTO_SPORT_EXTREME;
                });

        //Act
        CategoryDto category = productFacadeImpl.getCategoryById(1);

        //Assert
        assertNotNull(category);
        assertEquals(1, category.getCategoryId());
        assertEquals(Data.CATEGORY_DTO_SPORT_EXTREME.getNameCategory(), category.getNameCategory());
        verify(categoryService).getCategoryById(anyInt());
    }


    /**
     * Tests POST
     */

    @Test
    @DisplayName("Test Create Post")
    void createPostTest() {
        //Arrange
        when(userService.getUserById(1)).then(invocationOnMock -> {
            Data.USERDTO_JUAN.setUserId(1);
            return Data.USERDTO_JUAN;
        });

        when(categoryService.getCategoryById(1)).then(invocationOnMock -> {
            Data.CATEGORY_DTO_SPORT_EXTREME.setCategoryId(1);
            return Data.CATEGORY_DTO_SPORT_EXTREME;
        });

        when(productoService.getProductByName(Data.PRODUCTDTO_SPORT.getProductName()))
                .thenReturn(null);

        when(productoService.createProduct(Data.PRODUCTDTO_SPORT))
                .then(invocationOnMock -> {
                    Data.PRODUCTDTO_SPORT.setProductId(1);
                    return Data.PRODUCTDTO_SPORT;
                });

        when(postService.createPost(Data.POSTDTO_1))
                .then(invocationOnMock -> {
                    Data.POSTDTO_1.setPostId(1);
                    Data.POSTDTO_1.setProductoDto(Data.PRODUCTDTO_SPORT);
                    return Data.POSTDTO_1;
                });

        //Act
        PostDto postDto = productFacadeImpl.createPost(Data.POSTDTO_1);

        //Assert
        assertNotNull(postDto);

        verify(userService).getUserById(anyInt());
        verify(categoryService).getCategoryById(anyInt());
        verify(productoService).getProductByName(anyString());
        verify(productoService).createProduct(any(ProductoDto.class));
        verify(postService).createPost(any(PostDto.class));

    }

    @Test
    @DisplayName("Test Create Post Existing POst")
    void createPostExistingPostTest() {
        //Arrange
        when(userService.getUserById(1)).then(invocationOnMock -> {
            Data.USERDTO_JUAN.setUserId(1);
            return Data.USERDTO_JUAN;
        });

        when(categoryService.getCategoryById(1)).then(invocationOnMock -> {
            Data.CATEGORY_DTO_SPORT_EXTREME.setCategoryId(1);
            return Data.CATEGORY_DTO_SPORT_EXTREME;
        });

        when(productoService.getProductByName(Data.PRODUCTDTO_SPORT.getProductName()))
                .then(invocationOnMock -> {
                    Data.PRODUCTDTO_SPORT.setProductId(1);
                    return Data.PRODUCTDTO_SPORT;
                });

        when(postService.getPostByUserIdWithProductId(1, 1))
                .then(invocationOnMock -> {
                    Data.POSTDTO_1.setPostId(1);
                    return Data.POSTDTO_1;
                });


        //Act
        //Assert
        ExistingException e = assertThrows(ExistingException.class, () -> {
            productFacadeImpl.createPost(Data.POSTDTO_1);
        });
        assertEquals("El userId: 1 ya tiene una publicación registrada con el producto: Ball", e.getMessage());

        verify(userService).getUserById(anyInt());
        verify(categoryService).getCategoryById(anyInt());
        verify(productoService).getProductByName(anyString());
        verify(postService).getPostByUserIdWithProductId(anyInt(), anyInt());

    }


    @Test
    @DisplayName("Test Get Post By User Id With ProductId")
    void getPostByUserIdWithProductIdTest() {
        //Arrange
        when(postService.getPostByUserIdWithProductId(1, 1))
                .then(invocationOnMock -> {
                    Data.POSTDTO_1.setPostId(1);
                    return Data.POSTDTO_1;
                });

        //Act
        PostDto postDto = productFacadeImpl.getPostByUserIdWithProductId(1, 1);

        //Assert
        assertNotNull(postDto);
        verify(postService).getPostByUserIdWithProductId(anyInt(), anyInt());

    }

    //Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006)
    @Test
    @DisplayName("Test Get List Of Sellers Posts That User Followed")
    void getListOfSellersPostsThatUserFollowedTest() {
        //Arrange


        when(userService.getUserById(1)).thenReturn(Data.USERDTO_JUAN);

        when(followerService.getListFollowedByUser(1))
                .thenReturn(List.of(Data.FOLLOWER_DTO_JUAN_PEDRO));

        when(postService.getAllPostByUser(2))
                .thenReturn(List.of(Data.POSTDTO_1));

        //Act
        PostListDto postDto = productFacadeImpl.getListOfSellersPostsThatUserFollowed(1, "date_desc");

        //Assert
        assertNotNull(postDto);
        verify(userService).getUserById(anyInt());
        verify(followerService).getListFollowedByUser(anyInt());
        verify(postService).getAllPostByUser(anyInt());

    }

    //Verificar que el tipo de ordenamiento alfabético exista (US-0008)
    @Test
    @DisplayName("Test Get List Followers Post By that User Followed Order Invalid.")
    void getListOfSellersPostsThatUserFollowedIvalidOrderTest() {
        //Arrange

        //Act
        //Assert
        OrderNotExistingException e = assertThrows(OrderNotExistingException.class, () -> {
            productFacadeImpl.getListOfSellersPostsThatUserFollowed(1, "_desc");
        });

    }


    @Test
    @DisplayName("Test Create Post in Promo")
    void createPostInPromoTest() {
        //Arrange
        when(userService.getUserById(2)).thenReturn(Data.USERDTO_JUAN);

        when(categoryService.getCategoryById(1))
                .then(invocationOnMock -> {
                    Data.CATEGORY_DTO_SPORT_EXTREME.setCategoryId(anyInt());
                    return Data.CATEGORY_DTO_SPORT_EXTREME;
                });

        when(productoService.getProductByName(anyString()))
                .thenReturn(null);

        when(productoService.createProduct(Data.PRODUCTDTO_TECHNOLOGY))
                .then(invocationOnMock -> {
                    Data.PRODUCTDTO_TECHNOLOGY.setProductId(1);
                    return Data.PRODUCTDTO_TECHNOLOGY;
                });

        when(postService.createPost(Data.POSTDTO_PROMO))
                .then(invocationOnMock -> {
                    Data.POSTDTO_PROMO.setPostId(1);
                    return Data.POSTDTO_PROMO;
                });

        //Act
        productFacadeImpl.createPostInPromo(Data.POSTDTO_PROMO);

        //Assert
        verify(userService).getUserById(anyInt());
        verify(categoryService).getCategoryById(anyInt());
        verify(productoService).getProductByName(anyString());
        verify(productoService).createProduct(any(ProductoDto.class));
        verify(postService).createPost(any(PostDto.class));

    }


    @Test
    @DisplayName("Test Create Post in Promo Existing")
    void createPostInPromoExistingTest() {
        //Arrange
        when(userService.getUserById(2)).thenReturn(Data.USERDTO_JUAN);

        when(categoryService.getCategoryById(1))
                .then(invocationOnMock -> {
                    Data.CATEGORY_DTO_SPORT_EXTREME.setCategoryId(anyInt());
                    return Data.CATEGORY_DTO_SPORT_EXTREME;
                });

        when(productoService.getProductByName(anyString()))
                .then(invocationOnMock -> {
                    Data.PRODUCTDTO_SPORT.setProductId(1);
                    return Data.PRODUCTDTO_SPORT;
                });

        when(postService.getPostByUserIdWithProductId(2, 1))
                .thenReturn(Data.POSTDTO_PROMO);

        //Act
        //Assert
        ExistingException e = assertThrows(ExistingException.class, () -> {
            productFacadeImpl.createPostInPromo(Data.POSTDTO_PROMO);
        });
        assertEquals("El userId: 2 ya tiene una publicación registrada con el producto: Macbook Pro", e.getMessage());

        verify(userService).getUserById(anyInt());
        verify(categoryService).getCategoryById(anyInt());
        verify(productoService).getProductByName(anyString());
        verify(postService).getPostByUserIdWithProductId(anyInt(), anyInt());

    }


    @Test
    @DisplayName("Test Get the list of products in promotion of a given sellerId")
    void getCountProductPromGiveSellerIdTest() {
        //Arrange
        when(userService.getUserById(2))
                .then(invocationOnMock -> {
                    Data.USERDTO_PEDRO.setUserId(2);
                    return Data.USERDTO_PEDRO;
                });

        when(postService.getAllPostByUser(2))
                .thenReturn(List.of(Data.POSTDTO_PROMO));

        //Act
        PostProductPromoDto postPromo = productFacadeImpl.getCountProductPromGiveSellerId(2);

        //Assert
        assertAll(
                () -> assertEquals(2, postPromo.getUserId()),
                () -> assertEquals("Pedro", postPromo.getUserName()),
                () -> assertEquals(1, postPromo.getPromoProductsCount())
        );
        verify(userService).getUserById(anyInt());
        verify(postService).getAllPostByUser(anyInt());
    }


    @Test
    @DisplayName("Test get the list of products in promotion of a given sellerId")
    void getListProductPromGiveSellerIdTest() {
        //Arrange
        when(userService.getUserById(2))
                .then(invocationOnMock -> {
                    Data.USERDTO_PEDRO.setUserId(2);
                    return Data.USERDTO_PEDRO;
                });

        when(postService.getAllPostByUser(2))
                .thenReturn(List.of(Data.POSTDTO_PROMO));

        //Act
        PostProductPromoDto postPromo = productFacadeImpl.getListProductPromGiveSellerId(2);

        //Assert
        assertAll(
                () -> assertEquals(2, postPromo.getUserId()),
                () -> assertEquals("Pedro", postPromo.getUserName()),
                () -> assertEquals(1, postPromo.getPostList().size())
        );
        verify(userService).getUserById(anyInt());
        verify(postService).getAllPostByUser(anyInt());
    }
}


