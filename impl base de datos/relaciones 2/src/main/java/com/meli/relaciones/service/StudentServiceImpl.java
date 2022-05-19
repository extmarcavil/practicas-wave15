package com.meli.relaciones.service;

import com.meli.relaciones.dto.StudentDTO;
import com.meli.relaciones.entities.Course;
import com.meli.relaciones.entities.Student;
import com.meli.relaciones.repository.CourseRepository;
import com.meli.relaciones.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Override
    public StudentDTO save(Student student) {
        Set<Course> courses = student.getCourses();
        for (Course c : courses) {
            courseRepository.findById(c.getId()).orElseThrow(() -> new RuntimeException("No existe ese curso"));
        }
        student= studentRepository.save(student);
        StudentDTO stuDTO = new StudentDTO();
        stuDTO.setStudentId(student.getId());
        List<Long> id = new ArrayList<>();
        for (Course c: student.getCourses())
        {
            id.add(c.getId());
        }
        stuDTO.setCourses(id);
        return stuDTO;
    }
}
