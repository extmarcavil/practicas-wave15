package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.SubjectDTO;

public class SubjectFactory {
    public static SubjectDTO createSubject(String name, Double score) {
        SubjectDTO s1 = new SubjectDTO();
        s1.setName(name);
        s1.setScore(score);
        return s1;
    }
}
