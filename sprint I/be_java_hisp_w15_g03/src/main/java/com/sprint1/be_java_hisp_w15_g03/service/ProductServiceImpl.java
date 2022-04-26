package com.sprint1.be_java_hisp_w15_g03.service;

import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.model.Category;
import com.sprint1.be_java_hisp_w15_g03.model.Product;
import com.sprint1.be_java_hisp_w15_g03.model.Publication;
import com.sprint1.be_java_hisp_w15_g03.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void savePublication(PublicationDTO publication) {


        ModelMapper mm = new ModelMapper();
        Publication p = new Publication();

        p.setDate(publication.getDate());
        p.setDetail(mm.map(publication.getDetail(),Product.class));
        p.setPrice(publication.getPrice());
        p.setCategory(Category.values()[publication.getCategory()]);

        if (productRepository.userExist(publication.getUserId())) {
            productRepository.savePublication(publication.getUserId(), p);
        }
    }
}
