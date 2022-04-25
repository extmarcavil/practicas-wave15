package com.example.starwars.Controller;

import com.example.starwars.Service.CharacterServiceImp;
import com.example.starwars.Service.ICharacterService;
import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.dto.ResponseCharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    ICharacterService service;

    public CharacterController(ICharacterService service) {
        this.service = service;
    }


    @GetMapping("/findSW/{name}")
    public ResponseEntity<List<CharacterDTO>> encontrarPersonaje (@PathVariable String name){
        return new ResponseEntity<List<CharacterDTO>>(service.findchar(name), HttpStatus.I_AM_A_TEAPOT);
    }

}
