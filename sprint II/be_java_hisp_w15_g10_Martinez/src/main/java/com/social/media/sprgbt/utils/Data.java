package com.social.media.sprgbt.utils;

import com.social.media.sprgbt.dto.*;
import com.social.media.sprgbt.entity.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Data {

    /**
     * ***************************************************************************************************************
     */

    //FOLLOWERS
    public static final Follower FOLLOWER_JUAN_PEDRO = new Follower(null, 1, 2);
    public static final Follower FOLLOWER_PEDRO_JUAN = new Follower(null, 2, 1);
    public static final Follower FOLLOWER_PEDRO_FELIPE = new Follower(null, 2, 3);
    public static final Follower FOLLOWER_FELIPE_PEDRO = new Follower(null, 3, 2);

    //FOLLOWERS DTO
    public static final FollowerDto FOLLOWER_DTO_JUAN_PEDRO = new FollowerDto(null, 1, 2);

    /**
     * ***************************************************************************************************************
     */

    //CATEGORYS
    public static final Category CATEGORY_SPORT_EXTREME = new Category(null, "Sports Extreme");
    public static final Category CATEGORY_SPORT_CARS = new Category(null, "Sport Cars");
    public static final Category CATEGORY_TECHNOLOGY = new Category(null, "Technology");

    //CATEGORYS DTO
    public static final CategoryDto CATEGORY_DTO_SPORT_EXTREME = new CategoryDto(null, "Sports Extreme");

    /**
     * ***************************************************************************************************************
     */


    //PRODUCTS
    public static final Product PRODUCT_TECHNOLOGY = new Product(null, "Macbook Pro", "New", "Apple", "Blck", "Ultimate");
    public static final Product PRODUCT_SPORT = new Product(null, "Ball", "Used", "Fifa", "White", "Ultimate");
    public static final Product PRODUCT_MOTORING = new Product(null, "Aero Dynamic", "New", "Audi", "Blck", "Carbon Fibre");

    //PRODUCTS_DTOs
    public static final ProductoDto PRODUCTDTO_TECHNOLOGY = new ProductoDto(null, "Macbook Pro", "New", "Apple", "Blck", "Ultimate");
    public static final ProductoDto PRODUCTDTO_SPORT = new ProductoDto(null, "Ball", "Used", "Fifa", "White", "Ultimate");
    public static final ProductoDto PRODUCTDTO_MOTORING = new ProductoDto(null, "Aero Dynamic", "New", "Audi", "Blck", "Carbon Fibre");

    /**
     * ***************************************************************************************************************
     */

    //POSTS
    public static final Post POST_1 = new Post(null, 1, 1, 1, LocalDate.of(2022, 4, 9), 1000D, false, 0.0);
    public static final Post POST_1_1 = new Post(null, 2, 2, 1, LocalDate.now(), 1000D, false, 0.0);
    public static final Post POST_PROMO = new Post(null, 2, 1, 1, LocalDate.of(2022, 5, 5), 5000D, true, 2000D);
    public static final Post POST_2 = new Post(null, 3, 1, 1, LocalDate.now(), 10000D, false, 0.0);

    //POSTS DTO
    public static final PostDto POSTDTO_1 = new PostDto(null, 1, LocalDate.of(2022, 4, 9), PRODUCTDTO_SPORT, 1, 1000D, false, 0.0);
    public static final PostDto POSTDTO_1_1 = new PostDto(null, 2, LocalDate.now(), PRODUCTDTO_SPORT, 2, 1000D, false, 0.0);
    public static final PostDto POSTDTO_PROMO = new PostDto(null, 2, LocalDate.of(2022, 5, 5), PRODUCTDTO_TECHNOLOGY, 1, 5000D, true, 2000D);
    public static final PostDto POSTDTO_2 = new PostDto(null, 3, LocalDate.now(), PRODUCTDTO_MOTORING, 2, 10000D, false, 0.0);

    /**
     * ***************************************************************************************************************
     */
    /**
     * Creacion de Users DTOs
     */
    //List of Followers UserDto
    public static final List<UserDto> LIST_FOLLOWERS_PEDRO = Arrays.asList(new UserDto(null, "Juan", 0, Arrays.asList(), Arrays.asList()),
            new UserDto(null, "Felipe", 1, Arrays.asList(), Arrays.asList()));

    public static final List<UserDto> LIST_FOLLOWERS_FELIPE = Arrays.asList(
            new UserDto(null, "Pedro", 2, LIST_FOLLOWERS_PEDRO, Arrays.asList()
            ));

    /**
     * ***************************************************************************************************************
     */

    //List of Followed UserDto
    public static final List<UserDto> LIST_FOLLOWED_PEDRO = Arrays.asList(
            new UserDto(null, "Felipe", 1, LIST_FOLLOWERS_FELIPE, Arrays.asList())
    );

    public static final List<UserDto> LIST_FOLLOWED_JUAN = Arrays.asList(
            new UserDto(null, "Pedro", 2, LIST_FOLLOWERS_PEDRO, LIST_FOLLOWED_PEDRO)
    );

    public static final List<UserDto> LIST_FOLLOWED_FELIPE = Arrays.asList(
            new UserDto(null, "Pedro", 2, LIST_FOLLOWERS_PEDRO, LIST_FOLLOWED_PEDRO)
    );

    /**
     * ***************************************************************************************************************
     */

    /**
     * Creacion de Entitys para prueba de Repositorys
     */
    //USERS
    public static final User USER_JUAN = new User(null, "Juan");
    public static final User USER_PEDRO = new User(null, "Pedro");
    public static final User USER_FELIPE = new User(null, "Felipe");

    //UserDtos
    public static final UserDto USERDTO_JUAN = new UserDto(null, "Juan", 0, Arrays.asList(), LIST_FOLLOWED_JUAN);
    public static final UserDto USERDTO_PEDRO = new UserDto(null, "Pedro", 2, LIST_FOLLOWERS_PEDRO, LIST_FOLLOWED_PEDRO);
    public static final UserDto USERDTO_FELIPE = new UserDto(null, "Felipe", 1, LIST_FOLLOWERS_FELIPE, LIST_FOLLOWED_FELIPE);


}
