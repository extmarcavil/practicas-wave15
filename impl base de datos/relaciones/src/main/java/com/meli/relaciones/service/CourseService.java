package com.meli.relaciones.service;

import com.meli.relaciones.dto.CourseDto;
import com.meli.relaciones.dto.CourseDtoResp;
import com.meli.relaciones.dto.StudentDto;
import com.meli.relaciones.entities.Course;
import com.meli.relaciones.entities.Student;
import com.meli.relaciones.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

@Service
public class CourseService implements ICourseService{

    CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDtoResp> getAll() {
        ModelMapper model = new ModelMapper();

        List<Course> c = courseRepository.findAll();
        List<CourseDtoResp> response = getCourseDtoResp(c);
        return response;
    }

    private List<CourseDtoResp> getCourseDtoResp(List<Course> courseDtoResp) {
        ModelMapper modelMapper = new ModelMapper();
        List<CourseDtoResp> courseDtoList = courseDtoResp
                .stream()
                .map(course -> modelMapper.map(course, CourseDtoResp.class))
                .collect(Collectors.toList());
        return courseDtoList;
    }

    public CourseDto saveCourse(CourseDto courseDto) {
        ModelMapper model = new ModelMapper();

        Course course = model.map(courseDto, Course.class);
        Course c = courseRepository.save(course);
        CourseDto response = model.map(c, CourseDto.class);

        return response;
    }
}
