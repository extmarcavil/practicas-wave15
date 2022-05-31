package com.spring.crudconjpa.controller;

import com.spring.crudconjpa.model.Student;
import com.spring.crudconjpa.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    //CREATE
    @PostMapping("/create")
    public String createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "El estudiante se agrego correctamente";
    }

    //READ all
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    //UPDATE
    @PostMapping("/edit/{id}")
    public Student updateStudent(@PathVariable Long id,
                                 @RequestParam("name") String newName,
                                 @RequestParam("lastname") String newLastname) {
        Student student = studentService.findStudent(id);
        return studentService.updateStudent(student, newName, newLastname);
    }

    //DELETE
    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "El estudiante se eliminó correctamente";
    }

}
