package com.sprint.be_java_hisp_w15_g10.Controller;


import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserWithFollowersCountDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.VendedorsFollowedDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RequestMapping("users/")
@RestController
public class UserController {

    @GetMapping("{userId}/followers/count")
    public EntityResponse<UserWithFollowersCountDTO> getUserWitFollowersCount(@PathVariable int userId){
        return null;
    }

    @GetMapping("/{userId}/followed/list")
    public EntityResponse<VendedorsFollowedDTO> getVendorsFollow(@PathVariable int userId) {
        return null;
    }

}
