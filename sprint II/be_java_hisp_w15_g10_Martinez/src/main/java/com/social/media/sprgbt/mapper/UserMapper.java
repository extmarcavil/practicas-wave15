package com.social.media.sprgbt.mapper;

import com.social.media.sprgbt.dto.UserDto;
import com.social.media.sprgbt.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    @Autowired
    private ModelMapper mapper;


    public User mapToEntity(UserDto dto) {

        User entity = mapper.map(dto, User.class);

        return entity;
    }


    public UserDto mapToDto(User userEntity) {

        UserDto dto = mapper.map(userEntity, UserDto.class);

        return dto;
    }


}
