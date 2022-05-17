package com.example.family.repository;

import com.example.family.model.FamilyMembersModel;

import java.util.List;

public class FamilyRepository implements IFamilyRepository{

    List<FamilyMembersModel> database;

    @Override
    public List<FamilyMembersModel> getAllMembers() {
        return database;
    }
}
