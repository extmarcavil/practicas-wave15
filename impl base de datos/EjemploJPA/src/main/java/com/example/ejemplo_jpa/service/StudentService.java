package com.example.ejemplo_jpa.service;

import com.example.ejemplo_jpa.model.Student;
import com.example.ejemplo_jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService{

private final StudentRepository stuRepo;

 //Si implemento con constructor es así:
    public StudentService (StudentRepository stuRepo) {
        this.stuRepo = stuRepo;
    }

    @Override
    @Transactional (readOnly = true)
    public List<Student> getStudents() {
        List<Student> studentList = stuRepo.findAll();
        return studentList;
    }

    @Override
    @Transactional
    public void saveStudent(Student stu) {

        stuRepo.save(stu);
    }

    @Override
    @Transactional
    public void deleteStudent(long id) {
        stuRepo.deleteById(id);
    }

    //el método edit no existe más

    @Override
    @Transactional (readOnly = true)
    public Student findStudent(long id) {
        //acá si no encuentro el student, devuelvo null, eso hace el orElse
        Student stu=stuRepo.findById(id).orElse(null);
        return stu;
    }


}



