package com.sprint1.be_java_hisp_w15_g03.service;

import com.sprint1.be_java_hisp_w15_g03.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationPromoDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.*;
import com.sprint1.be_java_hisp_w15_g03.exception.CategoryNotFoundException;
import com.sprint1.be_java_hisp_w15_g03.exception.OrderInvalidException;
import com.sprint1.be_java_hisp_w15_g03.exception.PersonNotFoundException;
import com.sprint1.be_java_hisp_w15_g03.exception.ProductDuplicatedException;
import com.sprint1.be_java_hisp_w15_g03.model.Category;
import com.sprint1.be_java_hisp_w15_g03.model.Product;
import com.sprint1.be_java_hisp_w15_g03.model.Publication;
import com.sprint1.be_java_hisp_w15_g03.model.Seller;
import com.sprint1.be_java_hisp_w15_g03.repository.IMeliRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
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
     * Guardar una publicación
     * @param publication
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

        checkPublication(publication.getUserId(), p, product);

    }

    /**
     * Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas
     * dos semanas con ordenamiento por fecha.
     * @param userId
     * @param order
     * @return SellerPListDTO
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
     * Guardar un publicación de un nuevo producto en promoción
     * @param publication
     */
    @Override
    public void savePublicationPromo(PublicationPromoDTO publication) {

        Product product = modelMapper.map(publication.getDetail(), Product.class);
        Publication p = new Publication();
        p.setDate(publication.getDate());
        p.setDetail(product);
        p.setPrice(publication.getPrice());
        p.setHasPromo(publication.getHasPromo());
        p.setDiscount(publication.getDiscount());

        try {
            p.setCategory(Category.values()[publication.getCategory()]);
        } catch (Exception e) {
            throw new CategoryNotFoundException("La categoria " + publication.getCategory() + " no existe.");
        }

        checkPublication(publication.getUserId(), p, product);

    }

    /**
     * Obtener la cantidad de productos en promoción de un determinado vendedor
     * @param sellerId
     * @return SellerCountPPromoDTO
     */
    @Override
    public SellerCountPPromoDTO ProductsPromoCount(Integer sellerId) {
        if (repository.hasSeller(sellerId)) {
            Seller seller = repository.getSeller(sellerId);
            SellerCountPPromoDTO sellerCountPPDTO = modelMapper.map(seller, SellerCountPPromoDTO.class);
            List<Publication> pPromo= repository.getPublicacionesPromo(seller);
            sellerCountPPDTO.setPromoProductsCount(pPromo.size());
            return sellerCountPPDTO;
        } else {
            throw new PersonNotFoundException("El vendedor con el id: " + sellerId + " no existe");
        }

    }

    /**
     * Obtener un listado de todos los productos en promoción de un determinado vendedor
     * @param userId
     * @return SellerPPromoListDTO
     */
    @Override
    public SellerPPromoListDTO getPublicationsPPromoList(Integer userId) {

        if (repository.hasSeller(userId)) {
            Seller seller = repository.getSeller(userId);
            List<Publication> pPromo= repository.getPublicacionesPromo(seller);
            SellerPPromoListDTO publicationPromo = new SellerPPromoListDTO();

            publicationPromo.setPosts(pPromo.stream()
                    .map(publication -> {
                        PublicationPromoComDTO p = new PublicationPromoComDTO();
                        p.setDate(publication.getDate());
                        p.setPostId(publication.getPostId());
                        p.setDetail(modelMapper.map(publication.getDetail(), ProductDTO.class));
                        p.setPrice(publication.getPrice());
                        p.setCategory(publication.getCategory().ordinal());
                        p.setHasPromo(publication.getHasPromo());
                        p.setDiscount(publication.getDiscount());
                        return p;
                    })
                    .collect(Collectors.toList()));
            publicationPromo.setUserId(seller.getUserId());
            publicationPromo.setUserName(seller.getUserName());

            return publicationPromo;
        } else {
            throw new PersonNotFoundException("El vendedor con el id: " + userId + " no existe");
        }

    }

    /**
     * Controla si la publicación se puede realizar,
     * Chequea que el producto exista y los datos del mismo sean correctos; en caso de no existir el ID del producto,
     * crea un nuevo procuto.
     * También chequea que exista el vendedor
     * @param userId
     * @param p
     * @param product
     */
    public void checkPublication(Integer userId, Publication p, Product product){
        if (repository.hasSeller(userId)) {

            if (repository.hasProduct(product.getProductId()))
            {
                if( !repository.getProduct(product.getProductId()).equals(product)){
                    throw new ProductDuplicatedException("El producto existente no concuerda con los datos enviados.");
                }
            } else {
                repository.addProduct(product);
            }

            repository.savePublication(userId, p);

        } else {
            throw new PersonNotFoundException("El vendedor con el id: " + userId + " no existe");
        }

    }

    /**
     * Ordenamiento de publicaciones por fechas
     * @param publicationList
     * @param order
     * @return PublicationRespDTO
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
