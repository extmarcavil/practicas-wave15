package com.sprint1.be_java_hisp_w15_g03.service;

import com.sprint1.be_java_hisp_w15_g03.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.PublicationRespDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerPListDTO;
import com.sprint1.be_java_hisp_w15_g03.exception.CategoryNotFoundException;
import com.sprint1.be_java_hisp_w15_g03.exception.OrderInvalidException;
import com.sprint1.be_java_hisp_w15_g03.exception.PersonNotFoundException;
import com.sprint1.be_java_hisp_w15_g03.exception.ProductDuplicatedException;
import com.sprint1.be_java_hisp_w15_g03.model.Category;
import com.sprint1.be_java_hisp_w15_g03.model.Product;
import com.sprint1.be_java_hisp_w15_g03.model.Publication;
import com.sprint1.be_java_hisp_w15_g03.repository.IMeliRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.swing.text.StyledEditorKit;
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

            if (repository.hasProduct(product.getProductId()))
            {
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
