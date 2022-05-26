package com.example.ejemplo_jpa.service;

import com.example.ejemplo_jpa.model.Student;
import java.util.List;

public interface IStudentService {

    public List<Student> getStudents ();
    public void saveStudent (Student stu);
    public void deleteStudent (long id);
    public Student findStudent (long id);



}
