package com.example.starwars.controller;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.service.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindController {
  @Autowired
  private FindService findService;

  @GetMapping("/{query}")
  public List<CharacterDTO> find(@PathVariable String query) {
        return findService.find(query);
  }
}
