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

    @Override
    public PromoCountDT0 getPromoCount(int sellerId) {

        if(repository.hasSeller(sellerId)){
            List<Publication> promoPost = repository.getPromoPublication(sellerId);
            Seller seller = repository.getSeller(sellerId);
            return new PromoCountDT0(seller.getUserId(),seller.getUserName(),promoPost.size());
        }else{
            throw new PersonNotFoundException("El vendedor con el id: " + sellerId + " no existe");
        }
    }

    @Override
    public PromoListDTO getPromoList(int sellerId) {
        if(!repository.hasSeller(sellerId)){
            throw new PersonNotFoundException("El vendedor con el id: " + sellerId + " no existe");
        }
        Seller s = repository.getSeller(sellerId);
        List<Publication> publications =  repository.getPromoPublication(sellerId);
        List<PromoRespDTO> promoResp = publications.stream().map(publication -> new PromoRespDTO(publication.getPostId(),publication.getDate(), publication.getCategory().ordinal(),publication.getPrice(),modelMapper.map(publication.getDetail(), ProductDTO.class),publication.getHasPromo(),publication.getDiscount())).collect(Collectors.toList());
        return new PromoListDTO(s.getUserId(),s.getUserName(),promoResp);
    }

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

    @Override
    public void savePublicationWithoutPromo(PublicationDTO publication) {

        Product product = modelMapper.map(publication.getDetail(), Product.class);
        Publication p = new Publication();
        p.setDate(publication.getDate());
        p.setDetail(product);
        p.setPrice(publication.getPrice());
        p.setHasPromo(false);

        try {
            p.setCategory(Category.values()[publication.getCategory()]);
        } catch (Exception e) {
            throw new CategoryNotFoundException("La categoria " + publication.getCategory() + " no existe.");
        }

        savePublication(p, publication.getUserId());

    }


    @Override
    public void savePromoPublication (PublicationPromoDTO publication){

        Publication p = new Publication();
        Product product = modelMapper.map(publication.getDetail(), Product.class);
        p.setDate(publication.getDate());
        p.setDetail(product);
        p.setPrice(publication.getPrice());
        p.setDiscount(publication.getDiscount());
        p.setHasPromo(publication.getHas_promo());

        try {
            p.setCategory(Category.values()[publication.getCategory()]);
        } catch (Exception e) {
            throw new CategoryNotFoundException("La categoria " + publication.getCategory() + " no existe.");
        }

        savePublication(p,publication.getUserId());
    }

    private void savePublication(Publication publication, int userId){

        if (repository.hasSeller(userId)) {

            if (repository.hasProduct(publication.getDetail().getProductId()))
            {
                if( !repository.getProduct(publication.getDetail().getProductId()).equals(publication.getDetail())){
                    throw new ProductDuplicatedException("El producto existente no concuerda con los datos enviados.");
                }
            } else {
                repository.addProduct(publication.getDetail());
            }

            repository.savePublication(userId, publication);

        } else {
            throw new PersonNotFoundException("El vendedor con el id: " + userId + " no existe");
        }
    }



}
