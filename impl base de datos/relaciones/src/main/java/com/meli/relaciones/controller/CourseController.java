package com.meli.relaciones.controller;

import com.meli.relaciones.dto.CourseDto;
import com.meli.relaciones.dto.CourseDtoResp;
import com.meli.relaciones.dto.StudentDto;
import com.meli.relaciones.entities.Course;
import com.meli.relaciones.service.CourseService;
import com.meli.relaciones.service.ICourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {


    ICourseService service;

    public CourseController(ICourseService service) {
        this.service = service;
    }

    @GetMapping("/course/getAll")
    public ResponseEntity<List<CourseDtoResp>> getAllCurso(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PostMapping("/course/save")
    public ResponseEntity<CourseDto> newStudent(@RequestBody CourseDto courseDto){
        return ResponseEntity.ok().body(service.saveCourse(courseDto));
    }
}
