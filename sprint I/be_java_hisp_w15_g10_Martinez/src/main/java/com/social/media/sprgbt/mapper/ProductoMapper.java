package com.social.media.sprgbt.mapper;

import com.social.media.sprgbt.dto.ProductoDto;
import com.social.media.sprgbt.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    @Autowired
    private ModelMapper mapper;


    public Product mapToEntity(ProductoDto dto) {

        Product entity = mapper.map(dto, Product.class);

        return entity;
    }


    public ProductoDto mapToDto(Product entity) {

        ProductoDto dto = mapper.map(entity, ProductoDto.class);

        return dto;
    }

}
