package com.meli.relaciones.service;

import com.meli.relaciones.dto.CourseDto;
import com.meli.relaciones.dto.CourseDtoResp;
import com.meli.relaciones.entities.Course;

import java.util.List;

public interface ICourseService {

    List<CourseDtoResp> getAll();
    CourseDto saveCourse(CourseDto courseDto);

}
