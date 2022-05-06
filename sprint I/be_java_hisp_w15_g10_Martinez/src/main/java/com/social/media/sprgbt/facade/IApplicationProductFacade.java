package com.social.media.sprgbt.facade;

import com.social.media.sprgbt.dto.*;
import com.social.media.sprgbt.exception.ExistingException;
import com.social.media.sprgbt.exception.NotFoundException;

import java.util.List;

public interface IApplicationProductFacade {

    /**
     * Create Product
     *
     * @param dto param
     * @return {@link ProductoDto} obj
     * @throws ExistingException exception
     */
    ProductoDto createProduct(ProductoDto dto) throws ExistingException;

    /**
     * Get All Products
     *
     * @return {@link ProductoDto} list
     */
    List<ProductoDto> getAllProducts();

    /**
     * Get Product By Id
     *
     * @param id param
     * @return {@link ProductoDto} obj
     * @throws NotFoundException exception
     */
    ProductoDto getProductById(Integer id) throws NotFoundException;

    /**
     * Create CategoryDto
     *
     * @param categoryDto
     * @return {@link CategoryDto} obj
     */
    CategoryDto createCategory(CategoryDto categoryDto) throws ExistingException;

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
    CategoryDto getCategoryById(Integer id) throws NotFoundException;

    /**
     * Create Post
     *
     * @param postDto param
     * @return {@link PostDto} obj
     * @throws NotFoundException exception
     */
    PostDto createPost(PostDto postDto) throws NotFoundException;

    /**
     * Get List Of Sellers Posts That User Followed
     *
     * @param userId param
     * @return {@link PostListDto} obj
     * @throws NotFoundException
     */
    PostListDto getListOfSellersPostsThatUserFollowed(Integer userId, String order) throws NotFoundException;

    /**
     * Create Post in Promo
     *
     * @param postDto param
     * @return {@link PostDto} obj
     * @throws NotFoundException exception
     */
    public PostDto createPostInPromo(PostDto postDto) throws NotFoundException;

    /**
     * get the list of products in promotion of a given sellerId
     *
     * @param userId param
     * @return {@link PostListDto} obj
     * @throws NotFoundException
     */
    PostProductPromoDto getCountProductPromGiveSellerId(Integer userId) throws NotFoundException;

    /**
     * get the list of products in promotion of a given sellerId
     *
     * @param userId param
     * @return {@link PostListDto} obj
     * @throws NotFoundException
     */
    PostProductPromoDto getListProductPromGiveSellerId(Integer userId) throws NotFoundException;

}
