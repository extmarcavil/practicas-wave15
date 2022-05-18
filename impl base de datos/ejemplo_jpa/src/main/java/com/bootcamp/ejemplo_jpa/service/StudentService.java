package com.bootcamp.ejemplo_jpa.service;

import com.bootcamp.ejemplo_jpa.model.Student;
import com.bootcamp.ejemplo_jpa.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private final StudentRepository stuRepo;

    public StudentService(StudentRepository stuRepo) {
        this.stuRepo = stuRepo;
    }

    @Override
    @Transactional( readOnly = true)
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

    @Override
    @Transactional( readOnly = true)
    public Student findStudent(long id) {
        Student stu = stuRepo.findById(id).orElse(null);
        return stu;
    }
}
