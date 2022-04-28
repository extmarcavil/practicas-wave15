package com.bootcamp.be_java_hisp_w15_g08.service;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.PromoProductDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.*;
import com.bootcamp.be_java_hisp_w15_g08.model.Post;
import com.bootcamp.be_java_hisp_w15_g08.model.PromoProduct;
import com.bootcamp.be_java_hisp_w15_g08.model.User;
import com.bootcamp.be_java_hisp_w15_g08.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w15_g08.utils.SprintOneHelper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ProductService implements IProductService{
    IUserRepository repository;
    ModelMapper mapper;

    public ProductService (IUserRepository repository){
        this.repository = repository;
        mapper = new ModelMapper();
    }

    @Override
    public void addPromoProduct(PromoProductDTO product) {
        User user = repository.findUser(product.getUser_id());
        PromoProduct promoProduct = mapper.map(product,PromoProduct.class);
        promoProduct.setPost_id(repository.generateId());
        user.addPromoProduct(promoProduct);
        System.out.println(promoProduct);
        System.out.println(promoProduct.getDate());
    }

    @Override
    public PromoProductsCountDTO getPromoProductsCount(Integer userId) {
        User user = repository.findUser(userId);
        PromoProductsCountDTO promoCount = new PromoProductsCountDTO(userId, user.getName(), user.getPromoproducts().size());
        return promoCount;
    }

    @Override
    public PromoProductsListDTO getSellersProducts(Integer userId) {
        User user =repository.findUser(userId);
        List<PromoProductNotUserIdDTO> products = new ArrayList<>();
        products = user.getPromoproducts().values().stream()
                .map(product -> mapper.map(product, PromoProductNotUserIdDTO.class))
                .collect(toList());
        PromoProductsListDTO productList = new PromoProductsListDTO();
        productList.setUser_id(user.getUserID());
        productList.setUser_name(user.getName());
        productList.setPosts(products);
        return productList;
    }
}
