package com.social.media.sprgbt.mapper;

import com.social.media.sprgbt.dto.FollowerDto;
import com.social.media.sprgbt.entity.Follower;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FollowerMapper {


    @Autowired
    private ModelMapper mapper;


    public Follower mapToEntity(FollowerDto dto) {

        Follower entity = mapper.map(dto, Follower.class);

        return entity;
    }


    public FollowerDto mapToDto(Follower entity) {

        FollowerDto dto = mapper.map(entity, FollowerDto.class);

        return dto;
    }


}
