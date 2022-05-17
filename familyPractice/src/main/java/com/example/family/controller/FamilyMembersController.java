package com.example.family.controller;

import com.example.family.DTO.FamilyMembersDTOResponse;
import com.example.family.service.IFamilyMembersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FamilyMembersController {

    IFamilyMembersService service;
    @GetMapping("/get-members/")
    public ResponseEntity<List<FamilyMembersDTOResponse>> getAllMembers () {
        return new ResponseEntity<List<FamilyMembersDTOResponse>>(service.getAllMembers());
    }
}
