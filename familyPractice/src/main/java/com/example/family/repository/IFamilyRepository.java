package com.example.family.repository;

import com.example.family.DTO.FamilyMembersDTOResponse;
import com.example.family.model.FamilyMembersModel;

import java.util.List;

public interface IFamilyRepository {
    List<FamilyMembersModel> getAllMembers();
}
