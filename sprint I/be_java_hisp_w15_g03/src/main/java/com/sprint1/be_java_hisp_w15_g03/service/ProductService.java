package com.sprint1.be_java_hisp_w15_g03.service;

import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.exception.PersonNotFound;
import com.sprint1.be_java_hisp_w15_g03.model.Category;
import com.sprint1.be_java_hisp_w15_g03.model.Product;
import com.sprint1.be_java_hisp_w15_g03.model.Publication;
import com.sprint1.be_java_hisp_w15_g03.repository.IMeliRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    private IMeliRepository repository;

    private ModelMapper modelMapper;

    public ProductService(IMeliRepository repository) {
        this.repository = repository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void savePublication(PublicationDTO publication) {

        if (repository.hasSeller(publication.getUserId())) {

            Publication p = new Publication();

            p.setDate(publication.getDate());
            p.setDetail(modelMapper.map(publication.getDetail(),Product.class));
            p.setPrice(publication.getPrice());
            p.setCategory(Category.values()[publication.getCategory()]);
            repository.savePublication(publication.getUserId(), p);
        }else{
            throw new PersonNotFound("El vendedor con el id: " + publication.getUserId() + " no existe");
        }
    }
}
