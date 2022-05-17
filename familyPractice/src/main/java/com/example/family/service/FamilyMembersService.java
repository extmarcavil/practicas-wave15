package com.example.family.service;

import com.example.family.DTO.FamilyMembersDTOResponse;
import com.example.family.model.FamilyMembersModel;
import com.example.family.repository.IFamilyRepository;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class FamilyMembersService implements IFamilyMembersService{

    IFamilyRepository repository;

    private ModelMapper modelMapper;

    public FamilyMembersService(IFamilyRepository repository) {
        this.repository = repository;
        modelMapper = new ModelMapper();
    }

    @Override
    public List<FamilyMembersDTOResponse> getAllMembers() {
        List<FamilyMembersModel> repoList = repository.getAllMembers();
        List<FamilyMembersDTOResponse> response = repoList.stream().map(member -> modelMapper.map(member, FamilyMembersDTOResponse.class)).collect(Collectors.toList());

        return response;
    }
}
