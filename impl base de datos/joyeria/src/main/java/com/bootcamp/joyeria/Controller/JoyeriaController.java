package com.bootcamp.joyeria.Controller;

import com.bootcamp.joyeria.Dto.Request.JoyaRequestDTO;
import com.bootcamp.joyeria.Dto.Response.JoyaResponseCreatedDTO;
import com.bootcamp.joyeria.Model.Joya;
import com.bootcamp.joyeria.Service.Interfaces.JoyeriaInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyeriaController {

    private final JoyeriaInterface joyeriaService;

    public JoyeriaController(JoyeriaInterface joyeriaService) {
        this.joyeriaService = joyeriaService;
    }

    @PostMapping("/new")
    public ResponseEntity<JoyaResponseCreatedDTO> crearJoya(@RequestBody JoyaRequestDTO joyaRequestDTO) {
        joyeriaService.guardarJoya(joyaRequestDTO);
        return new ResponseEntity<JoyaResponseCreatedDTO>(new JoyaResponseCreatedDTO("Joya creada exitosamente"), org.springframework.http.HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<JoyaRequestDTO>> listarJoyas() {
        System.out.println(joyeriaService.listarJoyasVendidas());
        return new ResponseEntity<List<JoyaRequestDTO>>(joyeriaService.listarJoyasVendidas(), org.springframework.http.HttpStatus.OK);
    }

    @GetMapping("/todas")
    public List<Joya>joyas(){
        return joyeriaService.listarJoyas();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<JoyaResponseCreatedDTO> eliminarJoya(@PathVariable("id") Long id) {
        joyeriaService.eliminarJoya(id);
        return new ResponseEntity<JoyaResponseCreatedDTO>(new JoyaResponseCreatedDTO("Joya eliminada exitosamente"), org.springframework.http.HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JoyaRequestDTO> updateJoya(@PathVariable("id") Long id, @RequestBody JoyaRequestDTO joyaRequestDTO) {
        joyeriaService.actualizarJoya(id, joyaRequestDTO);
        return new ResponseEntity<JoyaRequestDTO>(joyaRequestDTO, org.springframework.http.HttpStatus.CREATED);
    }


}
