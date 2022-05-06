package com.sprint1.be_java_hisp_w15_g03_acosta.service;

import com.sprint1.be_java_hisp_w15_g03_acosta.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g03_acosta.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03_acosta.dto.response.PublicationRespDTO;
import com.sprint1.be_java_hisp_w15_g03_acosta.dto.response.SellerPListDTO;
import com.sprint1.be_java_hisp_w15_g03_acosta.exception.CategoryNotFoundException;
import com.sprint1.be_java_hisp_w15_g03_acosta.exception.OrderInvalidException;
import com.sprint1.be_java_hisp_w15_g03_acosta.exception.PersonNotFoundException;
import com.sprint1.be_java_hisp_w15_g03_acosta.exception.ProductDuplicatedException;
import com.sprint1.be_java_hisp_w15_g03_acosta.model.Category;
import com.sprint1.be_java_hisp_w15_g03_acosta.model.Product;
import com.sprint1.be_java_hisp_w15_g03_acosta.model.Publication;
import com.sprint1.be_java_hisp_w15_g03_acosta.repository.IMeliRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private final IMeliRepository repository;
    private final ModelMapper modelMapper;

    public ProductService(IMeliRepository repository) {
        this.repository = repository;
        this.modelMapper = new ModelMapper();
    }

    /**
     * Método para crear publicaciones.
     * @param publication Se recibe un PublicationDTO que contiene los datos necesarios para crear una publicación.
     * @throws CategoryNotFoundException la categoría que quiere agregar a la publicación no es válida.
     * @throws PersonNotFoundException el vendedor no existe en la base de datos.
     * @throws ProductDuplicatedException existe una inconsistencia en los datos del producto.
     *                                    Es decir que ya existe, pero los datos no son los mismos a los que se reciben.
     */
    @Override
    public void savePublication(PublicationDTO publication) {

        Product product = modelMapper.map(publication.getDetail(), Product.class);
        Publication p = new Publication();
        p.setDate(publication.getDate());
        p.setDetail(product);
        p.setPrice(publication.getPrice());

        try {
            p.setCategory(Category.values()[publication.getCategory()]);
        } catch (Exception e) {
            throw new CategoryNotFoundException("La categoria " + publication.getCategory() + " no existe.");
        }

        if (repository.hasSeller(publication.getUserId())) {

            if (repository.hasProduct(product.getProductId())) {
                if( !repository.getProduct(product.getProductId()).equals(product)){
                    throw new ProductDuplicatedException("El producto existente no concuerda con los datos enviados.");
                }
            } else {
                repository.addProduct(product);
            }

            repository.savePublication(publication.getUserId(), p);

        } else {
            throw new PersonNotFoundException("El vendedor con el id: " + publication.getUserId() + " no existe");
        }
    }

    /**
     * Método que devuelve las ultimas publicaciones hasta dos semanas atras de los vendedores seguidos
     * por un usuario específico.
     * @param userId Id que identifica al usuario que solicita las publicaciones
     * @param order Variable que designa el orden en el cual se devuelven las publicaciones.
     *              Por defecto devuelve las mas recientes primero.
     * @return retorna un SellerPListDTO que con un userId y una lista de publicaciones.
     * @throws PersonNotFoundException el userId no existe en la base de datos.
     */
    @Override
    public SellerPListDTO getLastPublication(int userId, String order) {

        if (!repository.hasUser(userId)) {
            throw new PersonNotFoundException("El usuario con el id: " + userId + " no existe");
        }

        SellerPListDTO followedPublications = new SellerPListDTO();
        followedPublications.setUserId(userId);
        List<PublicationRespDTO> publicationRespDTOList = repository.getLastPublications(userId).stream()
                .map(publication -> {
                    PublicationRespDTO p = new PublicationRespDTO();
                    p.setDate(publication.getDate());
                    p.setPostId(publication.getPostId());
                    p.setDetail(modelMapper.map(publication.getDetail(), ProductDTO.class));
                    p.setPrice(publication.getPrice());
                    p.setCategory(publication.getCategory().ordinal());
                    return p;
                })
                .collect(Collectors.toList());
        followedPublications.setPosts(orderByDate(publicationRespDTOList, order));
        return followedPublications;
    }

    /**
     * Método privado para ordenar una respectiva lista de publicaciones por fecha en el orden solicitado.
     * @param publicationList lista de publicaciones la cual se quiere ordenar.
     * @param order referente al orden que se quiere designar la lista recibida, puede ser asc o desc.
     * @return retorna una List<PublicationRespDTO> ordenada.
     */
    private List<PublicationRespDTO> orderByDate(List<PublicationRespDTO> publicationList, String order) {

        if (order != null) {

            switch (order) {
                case "date_asc":
                    publicationList.sort(Comparator.comparing(PublicationRespDTO::getDate));
                    break;
                case "date_desc":
                    publicationList.sort(Comparator.comparing(PublicationRespDTO::getDate).reversed());
                    break;
                default:
                    throw new OrderInvalidException("El orden solicitado no existe");
            }
        } else {
            publicationList.sort(Comparator.comparing(PublicationRespDTO::getDate).reversed());
        }

        return publicationList;
    }
}
