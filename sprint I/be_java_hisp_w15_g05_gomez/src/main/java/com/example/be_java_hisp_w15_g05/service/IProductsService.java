package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.*;

public interface IProductsService {
    /**
     * @param postDTO payload con la info enviada por el usuario
     * @return ResCreatePostDTO el cual solo contiene un mensaje informativo
     */
    ResCreatePostDTO createPost(PostDTO postDTO);

    /**
     * @param postPromoDTO payload con la info enviada por el usuario
     * @return ResCreatePostDTO el cual solo contiene un mensaje informativo
     */
    ResCreatePostDTO createPromoPost(PostPromoDTO postPromoDTO);

    /**
     * ATENCION: orden date_asc trae del post mas reciente al mas antiguo
     * y date_desc trae del post mas antiguo al mas reciente
     *
     * @param id    id del cliente
     * @param order metodo de ordenamiento, puede ser null
     * @return ResPostListDTO el cual contiene el id del cliente y la lista de post de las ultimas dos semanas
     */
    ResPostListDTO getPostFollowed(int id, String order);

    /**
     * @param id id del seller.
     * @return DTO con id y nombre de usuario y la cantidad de publicaciones en promo.
     */
    ResPostPromoCountDTO getPostPromoCount(int id);

    /**
     * @param id    id del seller
     * @param order name_asc o name_desc para ordenar
     * @return DTO con id y nombre del usuario y DTO 'posts'
     */
    ResPostPromoListDTO getPostPromoList(int id, String order);

    /**
     * @param id    del seller
     * @param order name_asc o name_desc para ordenar
     * @return DTO con id y nombre del usuario y DTO 'posts'
     */
    ResPostPromoListDTO getAllPost(int id, String order);
}
