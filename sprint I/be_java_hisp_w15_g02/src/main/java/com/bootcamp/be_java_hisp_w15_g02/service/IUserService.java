package com.bootcamp.be_java_hisp_w15_g02.service;

import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersBySellerDTO;

import java.util.List;

public interface IUserService {
    GetFollowersBySellerDTO getFollowersBySeller(int userId);
}
