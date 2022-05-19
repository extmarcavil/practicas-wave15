package com.meli.relaciones.controller;

import com.meli.relaciones.dto.CourseDto;
import com.meli.relaciones.dto.StudentDto;
import com.meli.relaciones.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping("/student/save")
    public ResponseEntity<StudentDto> newCourse(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok().body(service.saveCourse(studentDto));
    }

}