package com.example.family.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FamilyMembersModel {

    private int id;
    private String name;
    private String lastname;
    private int dni;
    private Date birthdate;
    private String familyCategory;

}
