package com.social.media.sprgbt.mapper;

import com.social.media.sprgbt.dto.PostDto;
import com.social.media.sprgbt.dto.ProductoDto;
import com.social.media.sprgbt.entity.Post;
import com.social.media.sprgbt.service.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IProductoService productoService;


    public Post mapToEntity(PostDto dto) {

        Post entity = mapper.map(dto, Post.class);
        entity.setProductId(dto.getProductoDto().getProductId());
        entity.setCategoryId(dto.getCategory());

        return entity;
    }

    public PostDto mapToDto(Post entity) {

        ProductoDto productoDto = productoService.getProductById(entity.getProductId());

        PostDto postDto = mapper.map(entity, PostDto.class);
        postDto.setProductoDto(productoDto);
        postDto.setCategory(entity.getCategoryId());

        return postDto;
    }
}
