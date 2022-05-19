package com.meli.relaciones.controller;

import com.meli.relaciones.dto.CourseDTO;
import com.meli.relaciones.entities.Course;
import com.meli.relaciones.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/new")
    public ResponseEntity<Course> save(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.save(course));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> find(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourse(id));
    }
}
