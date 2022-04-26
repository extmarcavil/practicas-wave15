package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FollowersListDTO {
    private Long userId;
    private String userName;
    List<UserDTO> users;
}
