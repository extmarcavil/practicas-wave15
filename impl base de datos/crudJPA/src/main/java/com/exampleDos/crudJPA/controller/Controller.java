package com.exampleDos.crudJPA.controller;

import com.exampleDos.crudJPA.model.Student;
import com.exampleDos.crudJPA.service.IStudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private final IStudentService stuService;

    public Controller(IStudentService stuService) {
        this.stuService = stuService;
    }

    @GetMapping ("/students")
    public List<Student> getStudents() {
        List<Student> studentList = stuService.getStudents();
        return studentList;
    }

    @PostMapping ("/create")
    public String createStudent(@RequestBody Student student) {
        stuService.saveStudent(student);
        return "El estudiante fue agregado correctamente";
    }

    @PostMapping("delete/{id}")
    public String deleteStudent (@PathVariable long id) {
        stuService.deleteStudent(id);
        return "El estudiante fue borrado correctamente";
    }

    @PostMapping ("edit/{id}")
    public Student editStudent (@PathVariable long id, @RequestParam ("name") String newName,
                                @RequestParam ("lastname") String newLastname) {
        Student stu = stuService.findStudent(id);
        stu.setLastname(newName);
        stu.setName(newLastname);
        stuService.saveStudent(stu);
        return stu;
    }

}
