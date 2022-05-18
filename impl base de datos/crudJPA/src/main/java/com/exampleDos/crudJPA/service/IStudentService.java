package com.exampleDos.crudJPA.service;

import com.exampleDos.crudJPA.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> getStudents();
    void saveStudent(Student stu);
    void deleteStudent(long id);
    Student findStudent(long id);



}
