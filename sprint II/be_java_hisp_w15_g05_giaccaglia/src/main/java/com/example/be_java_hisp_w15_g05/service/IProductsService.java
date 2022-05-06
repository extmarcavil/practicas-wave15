package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.PostDTO;
import com.example.be_java_hisp_w15_g05.dto.ResCreatePostDTO;
import com.example.be_java_hisp_w15_g05.dto.ResPostListDTO;

import java.util.List;

public interface IProductsService {

    /**
     * @param postDTO payload con la info enviada por el usuario
     * @return ResCreatePostDTO el cual solo contiene un mensaje informativo
     */
    ResCreatePostDTO createPost(PostDTO postDTO);

    /**
     * ATENCION: orden date_asc trae del post mas reciente al mas antiguo
     * y date_desc trae del post mas antiguo al mas reciente
     *
     * @param id    id del cliente
     * @param order metodo de ordenamiento, puede ser null
     * @return ResPostListDTO el cual contiene el id del cliente y la lista de post de las ultimas dos semanas
     */
    ResPostListDTO getPostFollowed(int id, String order);
}
