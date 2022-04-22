package ar.com.alehenestroza.apideportistas.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SportsController {
    @GetMapping("/findSports")
    public List<Object> findSports() {
        return null;
    }
    @GetMapping("/findSports/{sport}")
    public Object findSport(@PathVariable String sport) {
        return null;
    }
    @GetMapping("/findSportsPersons")
    public List<Object> findSportsPersons() {
        return null;
    }
}
