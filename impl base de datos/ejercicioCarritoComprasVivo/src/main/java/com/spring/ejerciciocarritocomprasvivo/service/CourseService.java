package com.spring.ejerciciocarritocomprasvivo.service;

import com.spring.ejerciciocarritocomprasvivo.dto.CourseDTO;
import com.spring.ejerciciocarritocomprasvivo.entities.Course;
import com.spring.ejerciciocarritocomprasvivo.repository.ICourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CourseService implements ICourseService{
    private final ICourseRepository courseRepository;

    public CourseService(ICourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void saveCourse(CourseDTO courseDTO) {
        ModelMapper mapper = new ModelMapper();
        courseRepository.findAll().forEach(course -> {
            if(course.getName().equals(courseDTO.getName())) {
                Course courseToAdd = mapper.map(courseDTO, Course.class);
                courseRepository.save(courseToAdd);
            }
        });
    }

}
