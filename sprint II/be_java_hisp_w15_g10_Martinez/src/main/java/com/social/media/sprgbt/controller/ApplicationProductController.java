package com.social.media.sprgbt.controller;

import com.social.media.sprgbt.dto.*;
import com.social.media.sprgbt.exception.ExistingException;
import com.social.media.sprgbt.exception.NotFoundException;
import com.social.media.sprgbt.facade.IApplicationProductFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ApplicationProductController {

    /**
     * ApplicationProductService Instance
     */
    private final IApplicationProductFacade applicationProductFacade;


    /**
     * Inyeccion de dependencia por constructor.
     *
     * @param applicationProductFacade instance
     */
    public ApplicationProductController(IApplicationProductFacade applicationProductFacade) {
        this.applicationProductFacade = applicationProductFacade;
    }


    /**
     * Create Product.
     *
     * @param dto
     * @return
     * @throws ExistingException
     */
    @PostMapping
    public ResponseEntity<ProductoDto> createProduct(@Valid @RequestBody ProductoDto dto) throws ExistingException {

        ProductoDto newDto = applicationProductFacade.createProduct(dto);

        return new ResponseEntity<>(newDto, HttpStatus.CREATED);
    }

    /**
     * Get All Product.
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<ProductoDto>> getAllProducts() {

        List<ProductoDto> listProducDto = applicationProductFacade.getAllProducts();

        return new ResponseEntity<>(listProducDto, HttpStatus.OK);
    }

    /**
     * Get Product By id.
     *
     * @param productId
     * @return
     * @throws NotFoundException
     */
    @GetMapping("/{productId}")
    public ResponseEntity<ProductoDto> getProductById(@PathVariable Integer productId) throws NotFoundException {

        ProductoDto dto = applicationProductFacade.getProductById(productId);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * Create Category.
     *
     * @param dto
     * @return
     * @throws ExistingException
     */
    @PostMapping("/category")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto dto) throws ExistingException {

        CategoryDto newDto = applicationProductFacade.createCategory(dto);

        return new ResponseEntity<>(newDto, HttpStatus.CREATED);
    }

    /**
     * Get All Catgorys.
     *
     * @return
     */
    @GetMapping("/category")
    public ResponseEntity<List<CategoryDto>> getAllCategory() {

        List<CategoryDto> listCategoryDto = applicationProductFacade.getAllCategory();

        return new ResponseEntity<>(listCategoryDto, HttpStatus.OK);
    }

    /**
     * Get Catgory By id.
     *
     * @param categoryId
     * @return
     * @throws NotFoundException
     */
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId) throws NotFoundException {

        CategoryDto dto = applicationProductFacade.getCategoryById(categoryId);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * Create Post
     *
     * @param postDto param
     * @return {@link PostDto} obj
     * @throws NotFoundException exception
     */
    @PostMapping("/post")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) throws NotFoundException {

        PostDto dto = applicationProductFacade.createPost(postDto);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * Get List Of Sellers Posts That User Followed
     *
     * @param userId param
     * @return {@link PostListDto} obj
     * @throws NotFoundException
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListDto> getListOfSellersPostsThatUserFollowed(@PathVariable Integer userId,
                                                                             @RequestParam(defaultValue = "date_asc") String order) throws NotFoundException {

        PostListDto postListDto = applicationProductFacade.getListOfSellersPostsThatUserFollowed(userId, order);

        return new ResponseEntity<>(postListDto, HttpStatus.OK);
    }


    /**
     * Create Post in Promo
     *
     * @param postDto param
     * @return {@link PostDto} obj
     * @throws NotFoundException exception
     */
    @PostMapping("/promo-post")
    public ResponseEntity<PostDto> createPostInPromo(@Valid @RequestBody PostDto postDto) throws NotFoundException {

        PostDto dto = applicationProductFacade.createPostInPromo(postDto);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * get Count of Product in Prom Give SellerId
     *
     * @param userId
     * @return
     * @throws NotFoundException
     */
    @GetMapping("/promo-post/count")
    public ResponseEntity<PostProductPromoDto> getCountProductPromGiveSellerId(@RequestParam(name = "user_id") Integer userId) throws NotFoundException {

        PostProductPromoDto dtoProm = applicationProductFacade.getCountProductPromGiveSellerId(userId);

        return new ResponseEntity<PostProductPromoDto>(dtoProm, HttpStatus.OK);
    }

    /**
     * get List of Product in Prom Give SellerId
     *
     * @param userId
     * @return
     * @throws NotFoundException
     */
    @GetMapping("/promo-post/list")
    public ResponseEntity<PostProductPromoDto> getListProductPromGiveSellerId(@RequestParam(name = "user_id") Integer userId) throws NotFoundException {

        PostProductPromoDto dtoProm = applicationProductFacade.getListProductPromGiveSellerId(userId);

        return new ResponseEntity<PostProductPromoDto>(dtoProm, HttpStatus.OK);
    }


}
