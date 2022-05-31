package com.spring.crudconjpa.service;

import com.spring.crudconjpa.model.Student;
import com.spring.crudconjpa.repository.IStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //CREATE de un elemento
    @Override
    @Transactional
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    //READ de todos los elementos
    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    //READ de un elemento
    @Override
    @Transactional(readOnly = true)
    public Student findStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(Student student, String newName, String newLastname) {
        student.setName(newName);
        student.setLastname(newLastname);
        studentRepository.save(student);
        return student;
    }

    //DELETE de un elemento
    @Override
    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
