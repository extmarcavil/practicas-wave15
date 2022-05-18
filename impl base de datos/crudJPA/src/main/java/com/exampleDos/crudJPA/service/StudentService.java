package com.exampleDos.crudJPA.service;

import com.exampleDos.crudJPA.model.Student;
import com.exampleDos.crudJPA.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    private final StudentRepository repo;

    public StudentService (StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public void saveStudent(Student stu) {
        repo.save(stu);
    }

    @Override
    @Transactional (readOnly = true)
    public List<Student> getStudents() {
        return repo.findAll();
    }

    @Override
    @Transactional
    public void deleteStudent(long id) {
        repo.deleteById(id);
    }

    @Override
    @Transactional (readOnly = true)
    public Student findStudent(long id) {
        return repo.findById(id).orElse(null);
    }
}



