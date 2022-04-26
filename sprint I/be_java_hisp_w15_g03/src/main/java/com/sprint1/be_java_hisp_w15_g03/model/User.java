package com.sprint1.be_java_hisp_w15_g03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends Person{

    private List<Seller> followed;

    @Override
    public String toString() {
        return null;
    }
}
