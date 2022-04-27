package com.meli.person.controller;

import com.meli.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("age/{day}/{month}/{year}")
    public int calculateAge(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        return personService.getAge(day, month, year);
    }

}
