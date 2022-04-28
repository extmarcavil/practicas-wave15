package com.sprint1.be_java_hisp_w15_g03.service;

import com.sprint1.be_java_hisp_w15_g03.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationPromoDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.*;
import com.sprint1.be_java_hisp_w15_g03.exception.CategoryNotFoundException;
import com.sprint1.be_java_hisp_w15_g03.exception.OrderInvalidException;
import com.sprint1.be_java_hisp_w15_g03.exception.ProductDuplicatedException;
import com.sprint1.be_java_hisp_w15_g03.model.Category;
import com.sprint1.be_java_hisp_w15_g03.model.Product;
import com.sprint1.be_java_hisp_w15_g03.model.Publication;
import com.sprint1.be_java_hisp_w15_g03.model.Seller;
import com.sprint1.be_java_hisp_w15_g03.repository.IMeliRepository;
import com.sprint1.be_java_hisp_w15_g03.utils.IUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private final IMeliRepository repository;
    private final ModelMapper modelMapper;
    private final IUtils utils;
    public ProductService(IMeliRepository repository, IUtils utils) {
        this.repository = repository;
        this.utils = utils;
        this.modelMapper = new ModelMapper();
    }


    /**
     * Se realiza una nueva publicacion y se agrega a la lista de publicaciones del vendedor
     * No se utilizo el mapper ya que no puede mapear el enumerado Category
     * @param publication: DTO con todos los datos de una publicacion sin descuento
     */
    @Override
    public void savePublication(PublicationDTO publication) {
        utils.existeSeller(publication.getUserId());
        Product product = modelMapper.map(publication.getDetail(), Product.class);
        Publication p = new Publication();
        p.setDate(publication.getDate());
        p.setDetail(product);
        p.setPrice(publication.getPrice());
        p.setHasPromo(false);
        p.setDiscount(0.0);
        try {
            p.setCategory(Category.values()[publication.getCategory()]);
        } catch (Exception e) {
            throw new CategoryNotFoundException("La categoria " + publication.getCategory() + " no existe.");
        }
        filtros(product );
        repository.savePublication(publication.getUserId(), p);


    }

    /**
     * Se obtienen las publicaciones de todos los seguidos por un usuario que hayan sido ingresadas en las ultimas dos semanas
     * @param userId usuario que se quiere consultar publicaciones de seguidores
     * @param order Si desea, puede ordenar las publicaciones por fecha
     * @return Devuelve un DTO generado con los datos del usuario y lista de publicaciones de las ultimas 2 semanas
     */
    @Override
    public SellerPListDTO getLastPublication(int userId, String order) {

        utils.existeUser(userId);
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
     * Almacena una publicacion con promocion.
     * @param publication A diferencia de savePublication, el DTO recibido trae los datos de la promo
     */
    @Override
    public void savePromoPublication(PublicationPromoDTO publication) {
        utils.existeSeller(publication.getUserId());
        Product product = modelMapper.map(publication.getDetail(), Product.class);
        Publication p = new Publication();

        p.setDate(publication.getDate());
        p.setDetail(product);
        try {
            p.setCategory(Category.values()[publication.getCategory()]);
        } catch (Exception e) {
            throw new CategoryNotFoundException("La categoria " + publication.getCategory() + " no existe.");
        }
        p.setPrice(publication.getPrice());
        p.setHasPromo(publication.getHasPromo());
        p.setDiscount(publication.getDiscount());
        filtros(product);
        repository.savePublication(publication.getUserId(), p);

    }


    /**
     * Obtiene la cantidad de promociones que tiene un vendedor
     * @param sellerId vendedor que se desea consultar
     * @return devuelve los datos del vendedor (id, nombre) y la cantidad de promos que tiene
     */
    @Override
    public SellerPromoCountDTO getPromoCount(Integer sellerId) {
        utils.existeSeller(sellerId);
        Seller seller = repository.getSeller(sellerId);
        SellerPromoCountDTO sellerPromoCountDTO = modelMapper.map(seller, SellerPromoCountDTO.class);
        sellerPromoCountDTO.setPromoProductsCount(repository.getPromoProduct(sellerId).size());
        return sellerPromoCountDTO;

    }

    /**
     * Obtiene una lista con todas las ofertas de un vendedor
     * @param sellerId especifica el vendedor por el que se consulta
     * @return se devuelven los datos del vendedor y la lista de promos.
     */
    @Override
    public SellerPPromoListDTO getPromoList(Integer sellerId, String order) {
        utils.existeSeller(sellerId);
        List<Publication> promoProduct = repository.getPromoProduct(sellerId);

        List<PublicationPromoRespDTO> publicationRespDTOList = promoProduct.stream()
                .map(publication -> {
                    PublicationPromoRespDTO p = new PublicationPromoRespDTO();
                    p.setDate(publication.getDate());
                    p.setPostId(publication.getPostId());
                    p.setDetail(modelMapper.map(publication.getDetail(), ProductDTO.class));
                    p.setPrice(publication.getPrice());
                    p.setCategory(publication.getCategory().ordinal());
                    p.setDiscount(publication.getDiscount());
                    p.setHasPromo(publication.getHasPromo());

                    return p;
                })
                .collect(Collectors.toList());

        SellerPPromoListDTO sellerDto = new SellerPPromoListDTO();
        sellerDto.setUserId(sellerId);
        sellerDto.setUserName(repository.getSeller(sellerId).getUserName());
        sellerDto.setPosts(orderList(publicationRespDTOList, order));
        return sellerDto;
    }



    /**
     * Metodo para realizar el orden de las publicaciones
     * @param publicationList lista de publicaciones a ordenar
     * @param order Metodo de orden requerido (date_asc o date_desc)
     * @return
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



    private List<PublicationPromoRespDTO> orderList(List<PublicationPromoRespDTO> publicationList, String order) {

        if (order != null) {

            switch (order) {
                case "date_asc":
                    publicationList.sort(Comparator.comparing(PublicationPromoRespDTO::getDate));
                    break;
                case "date_desc":
                    publicationList.sort(Comparator.comparing(PublicationPromoRespDTO::getDate).reversed());
                    break;
                default:
                    throw new OrderInvalidException("El orden solicitado no existe");
            }
        } else {
            publicationList.sort(Comparator.comparing(PublicationPromoRespDTO::getDate).reversed());
        }

        return publicationList;
    }


    /**
     * Metodo realizado para cuando se deben generar nuevos productos.
     * No se permite generar 2 productos con mismo id.
     * En caso que la publicacion tenga el mismo producto, debe tener los mismos datos representativos
     * @param product
     */
    private void filtros(Product product) {
        if (repository.hasProduct(product.getProductId())) {
            if (!repository.getProduct(product.getProductId()).equals(product)) {
                throw new ProductDuplicatedException("El producto existente no concuerda con los datos enviados.");
            }
        } else {
                repository.addProduct(product);
        }

    }
}
