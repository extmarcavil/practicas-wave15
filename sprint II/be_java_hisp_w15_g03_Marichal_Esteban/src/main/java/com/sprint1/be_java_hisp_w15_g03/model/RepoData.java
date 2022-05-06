package com.sprint1.be_java_hisp_w15_g03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class RepoData {

    private List<User> users;
    private List<Seller> sellers;
    private List<Publication> publications;

}
