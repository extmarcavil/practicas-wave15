package com.spring.crudconjpa.service;

import com.spring.crudconjpa.model.Student;

import java.util.List;

public interface IStudentService {
    //Post CREATE
    public void saveStudent(Student student);

    //Get List READ
    public List<Student> getStudents();

    //Get One READ
    public Student findStudent(Long id);

    //Post UPDATE
    public Student updateStudent(Student student, String newName, String newLastname);

    //Delete One DELETE
    public void deleteStudent(Long id);

}
