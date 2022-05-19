package com.meli.relaciones.service;

import com.meli.relaciones.dto.CourseDTO;
import com.meli.relaciones.dto.StudentDTO;
import com.meli.relaciones.entities.Course;
import com.meli.relaciones.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public CourseDTO getCourse(Long id) {
        Course c = courseRepository.findById(id).orElse(null);
        if (c == null) {
            return null;
        }
        CourseDTO course = new CourseDTO();
        course.setCourseId(id);
        List<StudentDTO> students = c.getStd().stream()
                .map(p -> new StudentDTO(p.getId()))
                .collect(Collectors.toList());
        course.setStudents(students);
        return course;
    }
}
