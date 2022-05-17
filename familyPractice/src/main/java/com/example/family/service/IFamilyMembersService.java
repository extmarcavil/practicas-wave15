package com.example.family.service;

import com.example.family.DTO.FamilyMembersDTOResponse;

import java.util.List;

public interface IFamilyMembersService {
    List<FamilyMembersDTOResponse> getAllMembers();
}
