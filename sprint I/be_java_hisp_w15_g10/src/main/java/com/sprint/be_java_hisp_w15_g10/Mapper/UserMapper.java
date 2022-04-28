package com.sprint.be_java_hisp_w15_g10.Mapper;

import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserDTO;
import com.sprint.be_java_hisp_w15_g10.Model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    private ModelMapper mapper;


    public User mapToEntity(UserDTO dto) {
        User entity = mapper.map(dto, User.class);
        return entity;
    }


    public UserDTO mapToDto(User userEntity) {
        UserDTO dto = mapper.map(userEntity, UserDTO.class);
        return dto;
    }
}
