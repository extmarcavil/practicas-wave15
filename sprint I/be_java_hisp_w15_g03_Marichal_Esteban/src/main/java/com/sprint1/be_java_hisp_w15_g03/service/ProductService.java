package com.sprint1.be_java_hisp_w15_g03.service;

import com.sprint1.be_java_hisp_w15_g03.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.PublicationWithPromoDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.*;
import com.sprint1.be_java_hisp_w15_g03.exception.CategoryNotFoundException;
import com.sprint1.be_java_hisp_w15_g03.exception.OrderInvalidException;
import com.sprint1.be_java_hisp_w15_g03.exception.PersonNotFoundException;
import com.sprint1.be_java_hisp_w15_g03.exception.ProductDuplicatedException;
import com.sprint1.be_java_hisp_w15_g03.model.*;
import com.sprint1.be_java_hisp_w15_g03.repository.IMeliRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private final IMeliRepository meliRepository;
    private final ModelMapper modelMapper;

    public ProductService(IMeliRepository repository) {
        this.meliRepository = repository;
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
            throw new CategoryNotFoundException("La categoría " + publication.getCategory() + " no existe.");
        }

        if (meliRepository.hasSeller(publication.getUserId())) {
            if (meliRepository.hasProduct(product.getProductId())) {
                if (!meliRepository.getProduct(product.getProductId()).equals(product)) {
                    throw new ProductDuplicatedException("El producto existente no concuerda con los datos enviados.");
                }
            } else {
                meliRepository.addProduct(product);
            }
            meliRepository.savePublication(publication.getUserId(), p);
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

        if (!meliRepository.hasUser(userId)) {
            throw new PersonNotFoundException("El usuario con el id: " + userId + " no existe");
        }

        SellerPListDTO followedPublications = new SellerPListDTO();
        followedPublications.setUserId(userId);
        List<PublicationRespDTO> publicationRespDTOList = meliRepository.getLastPublications(userId).stream()
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
     * Método para crear publicaciones con promociones.
     * @param publicationWithPromo recibe un PublicationWithPromoDTO que contiene los datos necesarios para
     *                             crear una publicación y los datos de la promo respectiva.
     * @throws CategoryNotFoundException la categoria que quiere agregar a la publicación no es válida.
     * @throws PersonNotFoundException el vendedor no existe en la base de datos.
     *  @throws ProductDuplicatedException existe una inconsistencia en los datos del producto.
     *                                    Es decir que ya existe, pero los datos no son los mismos a los que se reciben.
     */
    @Override
    public void savePublicationWithPromo(PublicationWithPromoDTO publicationWithPromo) {
        Product product = modelMapper.map(publicationWithPromo.getDetail(), Product.class);
        Publication publication = new Publication();
        publication.setDate(publicationWithPromo.getDate());
        publication.setDetail(product);
        publication.setPrice(publicationWithPromo.getPrice());
        publication.setDiscount(publicationWithPromo.getDiscount());
        publication.setHasPromo(publicationWithPromo.getHasPromo());
        try {
            publication.setCategory(Category.values()[publicationWithPromo.getCategory()]);
        } catch (Exception e) {
            throw new CategoryNotFoundException("La categoría " + publicationWithPromo.getCategory() + " no existe.");
        }

        if (meliRepository.hasSeller(publicationWithPromo.getUserId())) {
            if (meliRepository.hasProduct(publication.getDetail().getProductId())) {
                if (!meliRepository.getProduct(publication.getDetail().getProductId()).equals(publication.getDetail())) {
                    throw new ProductDuplicatedException("El producto existente no concuerda con los datos enviados.");
                }
            } else {
                meliRepository.addProduct(publication.getDetail());
            }
            meliRepository.savePublication(publicationWithPromo.getUserId(), publication);
        } else {
            throw new PersonNotFoundException("El vendedor con el id: " + publicationWithPromo.getUserId() + " no existe");
        }
    }

    /**
     * Método para solicitar la cantidad de promociones que tiene activas un vendedor específico.
     * @param sellerId Id que identifica al vendedor que solicita las publicaciones.
     * @return retorna un PublicationPCountDTO que contiene userId, userName y un Integer
     *         referente a la cantidad de publicaciones con promociones.
     * @throws PersonNotFoundException el vendedor no existe en la base de datos.
     */
    @Override
    public PublicationPCountDTO getPublicationsWithPromo(Integer sellerId) {
        if (!meliRepository.hasSeller(sellerId)) {
            throw new PersonNotFoundException("El vendedor con el id: " + sellerId + " no existe");
        }
        Seller seller = meliRepository.getSeller(sellerId);
        PublicationPCountDTO publicationPCount = modelMapper.map(seller, PublicationPCountDTO.class);
        publicationPCount.setPromoProductsCount(meliRepository.getPublicationsWithPromo(sellerId).size());
        return publicationPCount;
    }

    /**
     * Método para solicitar un lista de promociones que tiene activas un vendedor específico.
     * @param sellerId Id que identifica al vendedor que solicita las publicaciones.
     * @return retorna un PublicationPListDTO que contiene userId, userName y una lista de publicaciones.
     * @throws PersonNotFoundException el vendedor no existe en la base de datos.
     */
    @Override
    public PublicationPListDTO getPublicationsWithPromoList(Integer sellerId) {
        if (meliRepository.hasSeller(sellerId)) {
            Seller seller = meliRepository.getSeller(sellerId);
            PublicationPListDTO publicationPList = new PublicationPListDTO();

            List<PublicationRespWithPromoDTO> publicationWithPromoList = meliRepository.getPublicationsWithPromo(sellerId).stream()
                    .map(publication -> {
                        PublicationRespWithPromoDTO p = new PublicationRespWithPromoDTO();
                        p.setDate(publication.getDate());
                        p.setPostId(publication.getPostId());
                        p.setDetail(modelMapper.map(publication.getDetail(), ProductDTO.class));
                        p.setPrice(publication.getPrice());
                        p.setCategory(publication.getCategory().ordinal());
                        p.setHasPromo(publication.getHasPromo());
                        p.setDiscount(publication.getDiscount());
                        return p;
                    })
                    .collect(Collectors.toList());

            publicationPList.setPosts(publicationWithPromoList);
            publicationPList.setUserId(seller.getUserId());
            publicationPList.setUserName(seller.getUserName());
            return publicationPList;
        } else {
            throw new PersonNotFoundException("El vendedor con el id: " + sellerId + " no existe\"");
        }
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
