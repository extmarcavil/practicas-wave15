package com.social.media.sprgbt.facade.impl;

import com.social.media.sprgbt.dto.*;
import com.social.media.sprgbt.entity.User;
import com.social.media.sprgbt.exception.ExistingException;
import com.social.media.sprgbt.exception.NotFoundException;
import com.social.media.sprgbt.facade.IApplicationProductFacade;
import com.social.media.sprgbt.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ApplicationProductFacadeImpl implements IApplicationProductFacade {

    /**
     * PostService Instance.
     */
    private final IPostService postService;

    /**
     * CategoryService Instance.
     */
    private final ICategoryService categoryService;

    /**
     * ProductoService Instance.
     */
    private final IProductoService productoService;

    /**
     * IUserService instance.
     */
    private final IUserService userService;

    /**
     * IFollowerService instance
     */
    private final IFollowerService followerService;


    /**
     * Inyeccion de dependencia por constructor
     *
     * @param postService
     * @param categoryService
     * @param productoService
     */
    public ApplicationProductFacadeImpl(IPostService postService,
                                        ICategoryService categoryService,
                                        IProductoService productoService,
                                        IUserService userService,
                                        IFollowerService followerService) {
        this.postService = postService;
        this.categoryService = categoryService;
        this.productoService = productoService;
        this.userService = userService;
        this.followerService = followerService;
    }


    /**
     * Create Product
     *
     * @param dto param
     * @return {@link ProductoDto} obj
     * @throws ExistingException exception
     */
    @Override
    public ProductoDto createProduct(ProductoDto dto) throws ExistingException {
        return productoService.createProduct(dto);
    }

    /**
     * Get All Products
     *
     * @return {@link ProductoDto} list
     */
    @Override
    public List<ProductoDto> getAllProducts() {
        return productoService.getAllProducts();
    }

    /**
     * Get Product By Id
     *
     * @param id param
     * @return {@link ProductoDto} obj
     * @throws NotFoundException exception
     */
    @Override
    public ProductoDto getProductById(Integer id) throws NotFoundException {
        return productoService.getProductById(id);
    }

    /**
     * Create CategoryDto
     *
     * @param categoryDto
     * @return {@link CategoryDto} obj
     */
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) throws ExistingException {
        return categoryService.createCategory(categoryDto);
    }

    /**
     * Get All CategoryDto
     *
     * @return
     */
    @Override
    public List<CategoryDto> getAllCategory() {
        return categoryService.getAllCategory();
    }

    /**
     * Get CategoryDto By id
     *
     * @param id
     * @return {@link CategoryDto} obj
     */
    @Override
    public CategoryDto getCategoryById(Integer id) throws NotFoundException {
        return categoryService.getCategoryById(id);
    }

    /**
     * Create Post
     *
     * @param postDto param
     * @return {@link PostDto} obj
     */
    @Override
    public PostDto createPost(PostDto postDto) throws NotFoundException {

        userService.getUserById(postDto.getUserId());

        categoryService.getCategoryById(postDto.getCategory());

        ProductoDto productDto = productoService.getProductByName(postDto.getProductoDto().getProductName());

        PostDto existingPostDto = productDto != null ?
                getPostByUserIdWithProductId(postDto.getUserId(), productDto.getProductId()) :
                null;

        if (existingPostDto != null) {
            throw new ExistingException(String.format("El userId: %s ya tiene una publicación registrada con el producto: %s",
                    existingPostDto.getUserId(), existingPostDto.getProductoDto().getProductName()));
        }

        ProductoDto newProductDto = createProduct(postDto.getProductoDto());

        postDto.setProductoDto(newProductDto);

        return postService.createPost(postDto);
    }

    /**
     * getPostByUserIdWithProductId
     *
     * @param userId
     * @param productId
     * @return Post
     */
    private PostDto getPostByUserIdWithProductId(Integer userId, Integer productId) {
        return postService.getPostByUserIdWithProductId(userId, productId);
    }

    /**
     * Get List Of Sellers Posts That User Followed
     *
     * @param userId param
     * @return {@link PostListDto} obj
     * @throws NotFoundException
     */
    @Override
    public PostListDto getListOfSellersPostsThatUserFollowed(Integer userId, String order) throws NotFoundException {

        userService.getUserById(userId);

        PostListDto postListDto = new PostListDto();
        postListDto.setUserId(userId);

        List<PostDto> listPostDto = new ArrayList<>();

        List<FollowerDto> listSellersFollowedByUser = followerService.getListFollowedByUser(userId);

        for (FollowerDto mySeller : listSellersFollowedByUser) {

            List<PostDto> listPostBySeller = postService.getAllPostByUser(mySeller.getUserIdToFollow());

            //Orden Ascendente por default
            listPostBySeller = listPostBySeller.stream()
                    .sorted()
                    .collect(Collectors.toList());

            // Orden Descendente
            if ("date_desc".equals(order)) {
                listPostBySeller = listPostBySeller.stream().sorted(Collections.reverseOrder())
                        .collect(Collectors.toList());
            }

            for (PostDto myPostDto : listPostBySeller) {
                listPostDto.add(myPostDto);
            }
        }

        postListDto.setListPosts(listPostDto);

        return postListDto;
    }

    /**
     * Create Post in Promo
     *
     * @param postDto param
     * @return {@link PostDto} obj
     * @throws NotFoundException exception
     */
    @Override
    public PostDto createPostInPromo(PostDto postDto) throws NotFoundException {
        userService.getUserById(postDto.getUserId());

        categoryService.getCategoryById(postDto.getCategory());

        ProductoDto productDto = productoService.getProductByName(postDto.getProductoDto().getProductName());

        PostDto existingPostDto = productDto != null ?
                getPostByUserIdWithProductId(postDto.getUserId(), productDto.getProductId()) :
                null;

        if (existingPostDto != null) {
            throw new ExistingException(String.format("El userId: %s ya tiene una publicación registrada con el producto: %s",
                    existingPostDto.getUserId(), existingPostDto.getProductoDto().getProductName()));
        }

        ProductoDto newProductDto = productoService.createProduct(postDto.getProductoDto());

        postDto.setProductoDto(newProductDto);

        return postService.createPost(postDto);
    }

    /**
     * get the list of products in promotion of a given sellerId
     *
     * @param userId param
     * @return {@link PostListDto} obj
     * @throws NotFoundException
     */
    @Override
    public PostProductPromoDto getCountProductPromGiveSellerId(Integer userId) throws NotFoundException {

        UserDto seller = userService.getUserById(userId);

        List<PostDto> publicacionesVendedor = postService.getAllPostByUser(userId);

        List<PostDto> listPostInPromo = publicacionesVendedor.stream()
                .filter(p -> p.isHasPromo())
                .collect(Collectors.toList());

        Integer valor = listPostInPromo.size();
        Integer resultado = valor != 0 ? valor : 0;

        PostProductPromoDto postProductPromo = new PostProductPromoDto();

        postProductPromo.setUserId(userId);
        postProductPromo.setUserName(seller.getUserName());
        postProductPromo.setPromoProductsCount(resultado);


        return postProductPromo;
    }

    /**
     * get the list of products in promotion of a given sellerId
     *
     * @param userId param
     * @return {@link PostListDto} obj
     * @throws NotFoundException
     */
    @Override
    public PostProductPromoDto getListProductPromGiveSellerId(Integer userId) throws NotFoundException {
        UserDto seller = userService.getUserById(userId);

        List<PostDto> publicacionesVendedor = postService.getAllPostByUser(userId);

        List<PostDto> listPostInPromo = publicacionesVendedor.stream()
                .filter(p -> p.isHasPromo())
                .collect(Collectors.toList());

        PostProductPromoDto postProductPromo = new PostProductPromoDto();

        postProductPromo.setUserId(userId);
        postProductPromo.setUserName(seller.getUserName());
        postProductPromo.setPostList(listPostInPromo);

        return postProductPromo;
    }


}
