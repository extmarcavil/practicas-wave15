package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;

import java.util.HashSet;
import java.util.Set;

public class SchoolFactory {

    public static Set<StudentDTO> getAllStudents() {
        Set<StudentDTO> students = new HashSet<>();
        students.add(StudentFactory.studentJuan());
        students.add(StudentFactory.studentPedro());
        return students;
    }
}
