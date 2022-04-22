package ar.com.alehenestroza.apideportistas.controllers;

import ar.com.alehenestroza.apideportistas.models.Sport;
import ar.com.alehenestroza.apideportistas.services.SportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SportsController {
    private final SportService sportService;

    @GetMapping("/findSports")
    public List<Sport> findSports() {
        return this.sportService.findSports();
    }
    @GetMapping("/findSports/{sportName}")
    public Sport findSport(@PathVariable String sportName) {
        return this.sportService.findSport(sportName);
    }
}
