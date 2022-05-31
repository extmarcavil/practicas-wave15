package com.spring.ejerciciocarritocomprasvivo.service;

import com.spring.ejerciciocarritocomprasvivo.dto.StudentDTO;
import com.spring.ejerciciocarritocomprasvivo.entities.Course;
import com.spring.ejerciciocarritocomprasvivo.entities.Student;
import com.spring.ejerciciocarritocomprasvivo.repository.ICourseRepository;
import com.spring.ejerciciocarritocomprasvivo.repository.IStudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {
    private final IStudentRepository studentRepository;
    private final ICourseRepository courseRepository;

    public StudentService(IStudentRepository studentRepository, ICourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        ModelMapper mapper = new ModelMapper();
        Student student = mapper.map(studentDTO, Student.class);

        /*
        student.getCourses().forEach(course -> {
            courseRepository.findAll()
                    .stream()
                    .filter(courseDB -> courseDB.getName().equals(course.getName()))
                    .forEach(courseFiltrado -> {
                        course.setStudents(courseFiltrado.getStudents());
                        //courseRepository.save(course);
                    });
        });
         */

        StudentDTO studentResponse = mapper.map(student, StudentDTO.class);
        studentRepository.save(student);
        return studentResponse;
    }
}
